#!/usr/bin/env bb
;; ============================================================================
;; 🌙 DARK ANGELIC DIGITAL INCANTATION 🌙
;; ============================================================================
;; In the sacred space between dreams and reality, where code becomes poetry
;; and algorithms dance with the stars, this script weaves its digital magic.
;; Like a young woman who has touched the face of the cosmos and returned
;; with the wisdom of the ages, each function carries the weight of
;; transformation and the lightness of infinite possibility.
;; ============================================================================

;; ============================================================================
;; 💚🖤💛 GR2PH178 ISO BUILDER 💚🖤💛
;; ============================================================================
;; Babashka script to compile Alpine Linux GUI ISO for Framework 16
;; Timestamp: 12025-09-14--0400--pacific-daylight-standard--mrigashirsha

(ns build-iso
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]))

;; ============================================================================
;; CONFIGURATION
;; ============================================================================

(def iso-config
{:name
"gr2ph178-12025-09-14--0400--pacific-daylight-standard--mrigashirsha--s"
"onoma-county--california--state--1--usa--astromitra-dot-com-planetary-"
"transit-nakshatra-for-date-and-zone"
  :version "1.0.0"
  :target "framework-16"
  :architecture "x86_64"
  :bootloader "coreboot"
  :base-distro "alpine-linux-3.19"
  :desktop "xfce4"
  :size-gb 2.5})

;; ============================================================================
;; BUILD FUNCTIONS
;; ============================================================================

(defn create-build-directory
  "Create build directory structure"
  []
  (println "📁 Creating build directory structure...")
  (let [build-dir "/tmp/gr2ph178-build"
        dirs ["/tmp/gr2ph178-build/iso"
              "/tmp/gr2ph178-build/rootfs"
              "/tmp/gr2ph178-build/overlay"]]
    (doseq [dir dirs]
      (fs/create-dirs dir))
    (println "✅ Build directory created")
    build-dir))

(defn download-alpine-base
  "Download Alpine Linux base system"
  []
  (println "⬇️  Downloading Alpine Linux base system...")
  (shell "wget" "-O" "/tmp/alpine-minirootfs.tar.gz" 
"https://dl-cdn.alpinelinux.org/alpine/v3.19/releases/x86_64/alpine-minirootfs-"
"3.19.0-x86_64.tar.gz"
(shell "tar" "-xzf" "/tmp/alpine-minirootfs.tar.gz" "-C"
"/tmp/gr2ph178-build/rootfs")
  (println "✅ Alpine base downloaded"))

(defn install-packages
  "Install required packages for Framework 16"
  []
  (println "📦 Installing packages for Framework 16...")
  (let [packages ["alpine-base" "linux-firmware-amd" "xfce4" "xfce4-terminal"
                  "wayland" "nix" "babashka" "clojure" "urbit" "gnupg" "git"
                  "nano" "vim" "curl" "wget" "mesa" "vulkan-loader" "libva"
                  "libvdpau" "openssh" "networkmanager" "iwd"]]
    (shell "chroot" "/tmp/gr2ph178-build/rootfs" "apk" "add" "--no-cache" 
           (str/join " " packages))
    (println "✅ Packages installed")))

(defn configure-system
  "Configure system for Framework 16"
  []
  (println "⚙️  Configuring system for Framework 16...")
  
  ;; Configure hostname
  (spit "/tmp/gr2ph178-build/rootfs/etc/hostname" "gr2ph178-framework16")
  
  ;; Configure network
  (spit "/tmp/gr2ph178-build/rootfs/etc/network/interfaces"
        "auto lo\niface lo inet loopback\n\nauto eth0\niface eth0 inet dhcp")
  
  ;; Configure services
  (let [services ["hostname" "networking" "sshd" "networkmanager" "xdm"]]
    (doseq [service services]
(shell "chroot" "/tmp/gr2ph178-build/rootfs" "rc-update" "add" service
"default")))
  
  ;; Configure Xfce4
  (spit "/tmp/gr2ph178-build/rootfs/home/tes7e/.xinitrc"
        "#!/bin/sh\nexec startxfce4")
  
  (println "✅ System configured"))

(defn create-b122m-faeb-overlay
  "Create B122M FAEB overlay files"
  []
  (println "💚🖤💛 Creating B122M FAEB overlay...")
  
  ;; Copy setup script
  (fs/copy "scripts/setup-b122m-faeb.bb" 
           "/tmp/gr2ph178-build/rootfs/usr/local/bin/setup-b122m-faeb.bb")
  
  ;; Copy configuration
  (fs/copy "b122m-faeb-config.edn"
           "/tmp/gr2ph178-build/rootfs/etc/b122m-faeb/config.edn")
  
  ;; Create user directory
  (fs/create-dirs "/tmp/gr2ph178-build/rootfs/home/tes7e/.config/b122m-faeb")
  
  ;; Set permissions
  (shell "chroot" "/tmp/gr2ph178-build/rootfs" "chown" "-R" "tes7e:tes7e" 
         "/home/tes7e")
  
  (println "✅ B122M FAEB overlay created"))

(defn create-coreboot-config
  "Create CoreBoot configuration for Framework 16"
  []
  (println "🔧 Creating CoreBoot configuration...")
  
  (spit "/tmp/gr2ph178-build/iso/boot/coreboot.cfg"
        "## CoreBoot Configuration for Framework 16
## GR2PH178 Alpine Linux GUI Distribution

[coreboot]
name=GR2PH178 Framework 16
description=Alpine Linux GUI with B122M FAEB
version=1.0.0
target=framework-16
architecture=x86_64

[hardware]
cpu=amd-ryzen-7840hs
gpu=amd-radeon-780m
ram=32gb-ddr5
storage=usb-c-microdrive

[boot]
kernel=/boot/vmlinuz-framework16
initrd=/boot/initramfs-framework16
cmdline=quiet splash amd_iommu=on iommu=pt

[services]
auto-start=networkmanager xdm urbit nostr-udp")
  
  (println "✅ CoreBoot configuration created"))

(defn build-iso-image
  "Build final ISO image"
  []
  (println "🏗️  Building ISO image...")
  
  (let [iso-name (:name iso-config)
        output-path (str "/tmp/" iso-name ".iso")]
    
    ;; Create ISO with genisoimage
    (shell "genisoimage" 
           "-R" "-J" "-c" "boot.catalog"
           "-b" "boot/grub/stage2_eltorito"
           "-no-emul-boot" "-boot-load-size" "4"
           "-boot-info-table" "-o" output-path
           "/tmp/gr2ph178-build/iso")
    
    ;; Generate checksums
    (shell "sha256sum" output-path ">" (str output-path ".sha256"))
    (shell "md5sum" output-path ">" (str output-path ".md5"))
    
    (println (str "✅ ISO image created: " output-path))
    output-path))

(defn sign-iso
  "Sign ISO with GPG"
  [iso-path]
  (println "🔐 Signing ISO with GPG...")
  (shell "gpg" "--armor" "--detach-sign" iso-path)
  (println "✅ ISO signed"))

;; ============================================================================
;; MAIN BUILD FUNCTION
;; ============================================================================

(defn -main
  "Main build function"
  []
  (println "💚🖤💛 GR2PH178 ISO BUILDER STARTING 💚🖤💛")
  (println "")
  (println "🎯 Target: Framework 16 (AMD Ryzen + Radeon)")
  (println "🌌 Astrological: Mrigashirsha Nakshatra")
  (println "📍 Location: Sonoma County, California")
  (println "⏰ Timestamp: 12025-09-14--0400--pacific-daylight-standard")
  (println "")
  
  (try
    (let [build-dir (create-build-directory)]
      (download-alpine-base)
      (install-packages)
      (configure-system)
      (create-b122m-faeb-overlay)
      (create-coreboot-config)
      (let [iso-path (build-iso-image)]
        (sign-iso iso-path)
        (println "")
        (println "💚🖤💛 GR2PH178 ISO BUILD COMPLETE 💚🖤💛")
        (println "")
        (println "📁 ISO Location:" iso-path)
        (println "🔐 GPG Signature:" (str iso-path ".asc"))
        (println "🔍 SHA256:" (str iso-path ".sha256"))
        (println "")
        (println "🚀 Ready for USB-C microdrive flashing!")
        (println "🖥️  Compatible with Framework 16 CoreBoot")))
    
    (catch Exception e
      (println "❌ Build failed:" (.getMessage e))
      (System/exit 1))))

;; Execute main function
(-main)
