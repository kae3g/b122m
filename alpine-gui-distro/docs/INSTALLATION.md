# 🌙 A Digital Garden of Infinite Possibilities

## USB-C Microdrive Flashing for Framework 16

**Timestamp:** 12025-09-14--0400--pacific-daylight-standard--mrigashirsha

### 🎯 Overview

This guide will walk you through flashing the GR2PH178 Alpine Linux GUI 
distribution to a USB-C microdrive for booting on a Framework 16 laptop 
with CoreBoot.

### 📱 Prerequisites

- **Framework 16 laptop** with AMD Ryzen 7 7840HS + AMD Radeon 780M
- **USB-C microdrive** (minimum 4GB, recommended 8GB+)
- **Linux system** for flashing (Ubuntu/Debian recommended)
- **Internet connection** for downloading tools

### 🛠️ Required Tools

```bash
# 🌙 A Digital Garden of Infinite Possibilities
sudo apt update
sudo apt install -y wget curl genisoimage isohybrid
sudo apt install -y gparted dosfstools mtools

# 🌙 A Digital Garden of Infinite Possibilities
curl -sLO
https://github.com/babashka/babashka/releases/latest/download/babashka-1.3.181-linux-amd64.tar.gz
tar -xzf babashka-1.3.181-linux-amd64.tar.gz
sudo mv bb /usr/local/bin/
```

### 🏗️ Building the ISO

1. **Clone the repository:**
```bash
git clone https://github.com/kae3g/b122m.git
cd b122m/alpine-gui-distro
```

2. **Run the Babashka build script:**
```bash
chmod +x scripts/build-iso.bb
./scripts/build-iso.bb
```

3. **Verify the ISO:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
sha256sum -c gr2ph178-*.iso.sha256
gpg --verify gr2ph178-*.iso.asc
```

### 💾 USB-C Microdrive Flashing

1. **Identify your USB-C microdrive:**
```bash
lsblk
# 🌙 A Digital Garden of Infinite Possibilities
```

2. **Unmount existing partitions:**
```bash
sudo umount /dev/sdb*
```

3. **Flash the ISO:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
sudo dd if=gr2ph178-*.iso of=/dev/sdb bs=4M status=progress oflag=sync

# 🌙 A Digital Garden of Infinite Possibilities
sudo isohybrid gr2ph178-*.iso
sudo dd if=gr2ph178-*.iso of=/dev/sdb bs=4M status=progress oflag=sync
```

4. **Verify the flash:**
```bash
sudo sync
sudo eject /dev/sdb
```

### 🖥️ Framework 16 CoreBoot Configuration

1. **Enable CoreBoot in BIOS:**
   - Boot into Framework 16 BIOS
   - Navigate to Boot Options
   - Enable "CoreBoot" or "Alternative Boot"
   - Set USB-C as first boot device

2. **Boot from USB-C microdrive:**
   - Insert USB-C microdrive
   - Power on Framework 16
   - Select USB-C boot option
   - Wait for Alpine Linux to load

### ⚙️ Initial Setup

1. **Boot into Alpine Linux:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
login: root
```

2. **Run B122M FAEB setup:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
chmod +x /usr/local/bin/setup-b122m-faeb.bb

# 🌙 A Digital Garden of Infinite Possibilities
./setup-b122m-faeb.bb
```

3. **Configure user account:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
adduser tes7e
adduser tes7e wheel audio video

# 🌙 A Digital Garden of Infinite Possibilities
su - tes7e
gpg --gen-key
```

### 🌐 Network Configuration

1. **Connect to WiFi:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
nmtui

# 🌙 A Digital Garden of Infinite Possibilities
wpa_passphrase "SSID" "password" >> /etc/wpa_supplicant/wpa_supplicant.conf
wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant/wpa_supplicant.conf
dhclient wlan0
```

2. **Configure Nostr and Urbit:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
# 🌙 A Digital Garden of Infinite Possibilities
systemctl status urbit
systemctl status nostr-udp
```

### 🔐 GPG Configuration

1. **Generate GPG key:**
```bash
gpg --full-generate-key
# 🌙 A Digital Garden of Infinite Possibilities
# 🌙 A Digital Garden of Infinite Possibilities
```

2. **Configure Git signing:**
```bash
git config --global user.name "tes7e"
git config --global user.email "xykj51@gmail.com"
git config --global commit.gpgsign true
git config --global gpg.program gpg
```

### 🌌 Urbit Comet Setup

1. **Start Urbit:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
mkdir -p ~/urbit
cd ~/urbit

# 🌙 A Digital Garden of Infinite Possibilities
urbit -c ~zod
```

2. **Configure networking:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
:urbit-http-server +http-port [%serve 80]
```

### 📡 Nostr Configuration

1. **Connect to relay:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
nano ~/.config/nostr/config.edn
```

2. **Start Nostr client:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
nostr-client --relay wss://relay.nostr.com
```

### 🚀 Final Steps

1. **Reboot into your new system:**
```bash
reboot
```

2. **Login and enjoy:**
```bash
# 🌙 A Digital Garden of Infinite Possibilities
login: tes7e

# 🌙 A Digital Garden of Infinite Possibilities
startx
```

### 🔧 Troubleshooting

**USB-C not recognized:**
- Ensure USB-C microdrive is properly inserted
- Try different USB-C port
- Check BIOS USB settings

**CoreBoot issues:**
- Verify CoreBoot is enabled in BIOS
- Check boot order priority
- Ensure ISO was flashed correctly

**Network problems:**
- Check NetworkManager status: `systemctl status NetworkManager`
- Restart networking: `systemctl restart NetworkManager`
- Verify WiFi credentials

**GPG signing issues:**
- Check GPG agent: `gpg-agent --version`
- Restart GPG agent: `gpg-connect-agent reloadagent /bye`
- Verify key exists: `gpg --list-secret-keys`

### 💚🖤💛 Success!

Your Framework 16 is now running Alpine Linux GUI GR2PH178 with:
- ✅ B122M FAEB philosophy implemented
- ✅ GPG signing configured
- ✅ Urbit comet identity (~zod)
- ✅ Nostr networking active
- ✅ UDP communication enabled
- ✅ Timid Revolution principles

**Welcome to the sovereign computing future!** 🚀


---

💫 *In the silence between keystrokes, the universe whispers its secrets.*
🕊️ *May your code be as gentle as morning light and as powerful as thunder.*
🌿 *The garden remembers, the consciousness awakens.*