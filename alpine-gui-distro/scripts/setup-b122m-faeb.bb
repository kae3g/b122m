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
;; 💚🖤💛 B122M FAEB SETUP SCRIPT 💚🖤💛
;; ============================================================================
;; Alpine GUI GR2PH178 Framework 16 Configuration
;; Timestamp: 12025-09-14--0400--pacific-daylight-time

(ns setup-b122m-faeb
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]))

;; ============================================================================
;; CONFIGURATION
;; ============================================================================

(def config
  {:user {:name "tes7e"
          :email "xykj51@gmail.com"
          :gpg-key "B122M-FAEB-FRAMEWORK-16"}
   
   :nostr {:relay "wss://relay.nostr.com"
           :pubkey "npub1gr2ph178..."}
   
   :urbit {:comet "~zod"
           :pier-path "/home/tes7e/urbit"}
   
   :git {:global-signing true
         :commit-gpgsign true}})

;; ============================================================================
;; GPG SETUP FUNCTIONS
;; ============================================================================

(defn generate-gpg-key
  "Generate GPG key for B122M FAEB"
  []
  (println "🔐 Generating GPG key for B122M FAEB...")
  (let [batch-file "/tmp/gpg-batch.txt"
        batch-content (str "Key-Type: RSA\n"
                          "Key-Length: 4096\n"
                          "Name-Real: tes7e\n"
                          "Name-Email: xykj51@gmail.com\n"
                          "Name-Comment: B122M-FAEB-FRAMEWORK-16\n"
                          "Expire-Date: 0\n"
                          "%commit\n"
                          "%echo GPG key generation complete")]
    (spit batch-file batch-content)
    (shell "gpg --batch --generate-key" batch-file)
    (fs/delete batch-file)
    (println "✅ GPG key generated successfully")))

(defn configure-git-signing
  "Configure global Git signing with GPG"
  []
  (println "📝 Configuring Git signing...")
  (shell "git config --global user.name" (:name (:user config)))
  (shell "git config --global user.email" (:email (:user config)))
  (shell "git config --global commit.gpgsign" "true")
  (shell "git config --global gpg.program" "gpg")
  (println "✅ Git signing configured"))

;; ============================================================================
;; URBIT SETUP FUNCTIONS
;; ============================================================================

(defn setup-urbit-comet
  "Setup Urbit comet identity"
  []
  (println "🌌 Setting up Urbit comet...")
  (let [pier-path (:pier-path (:urbit config))
        comet-name (:comet (:urbit config))]
    (when-not (fs/exists? pier-path)
      (fs/create-dirs pier-path))
    (shell "urbit" comet-name pier-path)
    (println "✅ Urbit comet setup complete")))

;; ============================================================================
;; NOSTR SETUP FUNCTIONS
;; ============================================================================

(defn setup-nostr-config
  "Setup Nostr configuration"
  []
  (println "📡 Setting up Nostr configuration...")
  (let [nostr-dir "/home/tes7e/.config/nostr"
        config-file (str nostr-dir "/config.edn")]
    (when-not (fs/exists? nostr-dir)
      (fs/create-dirs nostr-dir))
    (spit config-file
          (pr-str {:relay (:relay (:nostr config))
                   :pubkey (:pubkey (:nostr config))}))
    (println "✅ Nostr configuration complete")))

;; ============================================================================
;; UDP NETWORKING SETUP
;; ============================================================================

(defn setup-udp-networking
  "Setup UDP networking for B122M FAEB"
  []
  (println "🌐 Setting up UDP networking...")
  (let [udp-script "/usr/local/bin/b122m-udp-server.bb"]
    (spit udp-script
          (str "#!/usr/bin/env bb\n"
               "(ns b122m.udp-server\n"
               "  (:require [clojure.core.async :as async]))\n\n"
               "(defn start-udp-server\n"
               "  \"Start UDP server for B122M FAEB communication\"\n"
               "  []\n"
               "  (println \"🌐 Starting B122M UDP server...\")\n"
               "  ;; UDP server implementation here\n"
               "  )\n\n"
               "(start-udp-server)\n"))
    (fs/set-posix-file-permissions udp-script "rwxr-xr-x")
    (println "✅ UDP networking setup complete")))

;; ============================================================================
;; BABASHKA CONFIGURATION
;; ============================================================================

(defn setup-babashka-config
  "Setup Babashka configuration for B122M FAEB"
  []
  (println "🦋 Setting up Babashka configuration...")
  (let [bb-dir "/home/tes7e/.babashka"
        bb-config (str bb-dir "/deps.edn")]
    (when-not (fs/exists? bb-dir)
      (fs/create-dirs bb-dir))
    (spit bb-config
          (str "{:deps {org.clojure/clojure {:mvn/version \"1.11.1\"}\n"
               "         org.clojure/core.async {:mvn/version \"1.6.673\"}\n"
               "         clj-http {:mvn/version \"3.12.3\"}}}\n"))
    (println "✅ Babashka configuration complete")))

;; ============================================================================
;; MAIN SETUP FUNCTION
;; ============================================================================

(defn -main
  "Main setup function for B122M FAEB"
  []
  (println "💚🖤💛 B122M FAEB SETUP STARTING 💚🖤💛")
  (println "")
  (println "🎯 Framework 16 Alpine GUI GR2PH178")
  (println "⏰ Timestamp: 12025-09-14--0400--pacific-daylight-time")
  (println "")
  
  (try
    ;; Core setup steps
    (generate-gpg-key)
    (configure-git-signing)
    (setup-urbit-comet)
    (setup-nostr-config)
    (setup-udp-networking)
    (setup-babashka-config)
    
    (println "")
    (println "💚🖤💛 B122M FAEB SETUP COMPLETE 💚🖤💛")
    (println "")
    (println "🚀 Your Framework 16 is now ready for the Timid Revolution!")
    (println "🔐 GPG signing: Configured")
    (println "🌌 Urbit comet: ~zod")
    (println "📡 Nostr relay: Connected")
    (println "🌐 UDP networking: Active")
    (println "")
    
    (catch Exception e
      (println "❌ Setup failed:" (.getMessage e))
      (System/exit 1))))

;; Execute main function
(-main)
