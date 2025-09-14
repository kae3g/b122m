# ============================================================================
# 💚🖤💛 ALPINE GUI GR2PH178 NIX CONFIGURATION 💚🖤💛
# ============================================================================
# B122M FAEB Framework 16 Distribution
# Timestamp: 12025-09-14--0400--pacific-daylight-time

{ pkgs, lib, config, ... }:

{
  # ==========================================================================
  # SYSTEM CONFIGURATION
  # ==========================================================================
  
  system = {
    architecture = "x86_64";
    target = "framework-16";
    cpu = "amd-ryzen-7840hs";
    gpu = "amd-radeon-780m";
  };

  # ==========================================================================
  # PACKAGE INSTALLATION
  # ==========================================================================
  
  environment.systemPackages = with pkgs; [
    # Base Alpine packages
    alpine-base
    linux-firmware-amd
    
    # Desktop Environment
    xfce.xfce4-session
    xfce.xfce4-panel
    xfce.xfce4-terminal
    xfce.xfce4-settings
    wayland
    
    # Core B122M FAEB Stack
    nix
    babashka
    clojure
    urbit
    
    # Security & Development
    gnupg
    git
    nano
    vim
    curl
    wget
    
    # Framework 16 Hardware Support
    linux-firmware
    mesa
    vulkan-loader
    libva
    libvdpau
  ];

  # ==========================================================================
  # FRAMEWORK 16 HARDWARE CONFIGURATION
  # ==========================================================================
  
  hardware = {
    # AMD GPU Configuration
    opengl = {
      enable = true;
      driSupport = true;
      driSupport32Bit = true;
    };
    
    # CPU Power Management
    cpu.amd.updateMicrocode = true;
    
    # USB-C Support
    usb-modeswitch.enable = true;
  };

  # ==========================================================================
  # NETWORKING CONFIGURATION
  # ==========================================================================
  
  networking = {
    hostName = "gr2ph178-framework16";
    
    # UDP Networking for Nostr/Urbit
    firewall = {
      enable = true;
      allowedUDPPorts = [ 80 443 8080 8443 ];
    };
  };

  # ==========================================================================
  # USER CONFIGURATION
  # ==========================================================================
  
  users = {
    defaultUserShell = pkgs.bash;
    
    users.tes7e = {
      isNormalUser = true;
      extraGroups = [ "wheel" "audio" "video" "networkmanager" ];
      uid = 1000;
      
      # GPG Configuration
      openssh.authorizedKeys.keys = [
        "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGr2ph178... tes7e@gr2ph178"
      ];
    };
  };

  # ==========================================================================
  # SERVICES CONFIGURATION
  # ==========================================================================
  
  services = {
    # Display Manager
    xserver = {
      enable = true;
      displayManager = {
        defaultSession = "xfce";
      };
      desktopManager.xfce = {
        enable = true;
      };
    };
    
    # GPG Agent
    pcscd.enable = true;
    
    # NetworkManager
    networkmanager = {
      enable = true;
      wifi.backend = "iwd";
    };
  };

  # ==========================================================================
  # SECURITY CONFIGURATION
  # ==========================================================================
  
  security = {
    # GPG Configuration
    gpg = {
      enable = true;
      agent = {
        enable = true;
        enableSSHSupport = true;
      };
    };
    
    # AppArmor
    apparmor = {
      enable = true;
      enableCache = true;
    };
  };

  # ==========================================================================
  # B122M FAEB SPECIFIC CONFIGURATION
  # ==========================================================================
  
  # EDN Configuration Storage
  environment.etc."b122m-faeb/config.edn" = {
    text = ''
      {:system
       {:name "gr2ph178"
        :version "1.0.0"
        :target "framework-16"}
       
       :user
       {:name "tes7e"
        :email "xykj51@gmail.com"
        :gpg-key "B122M-FAEB-FRAMEWORK-16"}
       
       :network
       {:nostr-relay "wss://relay.nostr.com"
        :urbit-comet "~zod"
        :udp-enabled true}
       
       :philosophy
       {:name "Timid Revolution"
        :principles ["privacy" "decentralization" "sovereignty"]}}
    '';
  };

  # ==========================================================================
  # BOOT CONFIGURATION
  # ==========================================================================
  
  boot = {
    # coreboot support
    kernelParams = [
      "quiet"
      "splash"
      "amd_iommu=on"
      "iommu=pt"
    ];
    
    # Framework 16 specific
    initrd = {
      availableKernelModules = [
        "ahci"
        "xhci_pci"
        "nvme"
        "usb_storage"
        "sd_mod"
      ];
    };
  };

  # ==========================================================================
  # SYSTEM STATE VERSION
  # ==========================================================================
  
  system.stateVersion = "23.11";
}
