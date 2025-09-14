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
;; 💚🖤💛 BABASHKA NIX INTERFACE 💚🖤💛
;; ============================================================================
;; Helen Atthowe Ecological Farming Approach to Nix Package Management
;; Timestamp: 12025-09-14--0510--pacific-daylight-standard--mrigashirsha

(ns babashka-nix-interface
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]))

;; ============================================================================
;; NIX INTERFACE METAPHORS (HELEN ATTHOWE INSPIRED)
;; ============================================================================

(def nix-metaphors
  {:nix-store
   "Like Helen's seed bank - a repository of pure, reproducible packages
    where each package is stored with its exact dependencies and build inputs"
   
   :nix-shell
   "Like Helen's greenhouse - a controlled environment where specific
    conditions are maintained for optimal growth of particular crops"
   
   :nix-flakes
   "Like Helen's crop rotation plan - a systematic approach to managing
    different growing seasons and ensuring soil health through variety"
   
   :nix-gc
   "Like Helen's composting system - recycling unused materials back
    into the soil to maintain fertility and reduce waste"
   
   :nix-channel
   "Like Helen's seed catalogs - curated collections of packages
    that have been tested and proven to work well together"
   
   :nix-derivation
   "Like Helen's planting instructions - precise recipes that ensure
    each crop is grown under optimal conditions with exact inputs"})

;; ============================================================================
;; NIX OPERATIONS (FARMING OPERATIONS)
;; ============================================================================

(defn nix-search
  "Search for packages in the Nix ecosystem - like browsing seed catalogs"
  [query]
  (println (str "🔍 Searching Nix packages for: " query))
  (println "📚 Like browsing Helen Atthowe's seed catalogs...")
  (let [result (shell {:out :string} "nix" "search" "nixpkgs" query)]
    (if (str/includes? result "error")
      (println "❌ Search failed - package catalog may be outdated")
      (do (println "✅ Found packages:")
          (println result)))))

(defn nix-install
  "Install a package using Nix - like planting seeds in prepared soil"
  [package-name]
  (println (str "🌱 Installing package: " package-name))
  (println "🌾 Like Helen planting seeds in her prepared soil...")
  (try
    (shell "nix-env" "-iA" "nixpkgs." package-name)
    (println (str "✅ " package-name " planted successfully"))
    (catch Exception e
      (println (str "❌ Planting failed: " (.getMessage e))))))

(defn nix-shell
  "Enter a Nix shell environment - like entering Helen's greenhouse"
  [packages]
  (println "🏠 Entering Nix shell environment...")
  (println "🌱 Like stepping into Helen's controlled greenhouse...")
  (let [package-list (str/join " " packages)]
    (println (str "📦 Available packages: " package-list))
    (shell "nix-shell" "-p" package-list "--run" "bash")))

(defn nix-build
  "Build a Nix derivation - like following Helen's planting instructions"
  [derivation-path]
  (println (str "🔨 Building derivation: " derivation-path))
  (println "📋 Like following Helen's precise planting instructions...")
  (try
    (let [result (shell {:out :string} "nix-build" derivation-path)]
      (println "✅ Build completed successfully")
      (println (str "📁 Output: " result)))
    (catch Exception e
      (println (str "❌ Build failed: " (.getMessage e))))))

(defn nix-gc
  "Run garbage collection - like Helen's composting system"
  []
  (println "♻️  Running Nix garbage collection...")
  (println "🌱 Like Helen's composting system recycling nutrients...")
  (try
    (shell "nix-collect-garbage" "-d")
    (println "✅ Garbage collection complete - system cleaned")
    (catch Exception e
      (println (str "❌ Cleanup failed: " (.getMessage e))))))

(defn nix-optimise
  "Optimize the Nix store - like Helen optimizing her soil structure"
  []
  (println "⚡ Optimizing Nix store...")
  (println "🌱 Like Helen optimizing her soil structure for better drainage...")
  (try
    (shell "nix-store" "--optimise")
    (println "✅ Store optimization complete")
    (catch Exception e
      (println (str "❌ Optimization failed: " (.getMessage e))))))

;; ============================================================================
;; NIX FLOWERS (FLAKES) INTERFACE
;; ============================================================================

(defn flake-init
  "Initialize a new Nix flake - like starting a new field rotation plan"
  [flake-name]
  (println (str "🌿 Initializing Nix flake: " flake-name))
  (println "📋 Like Helen starting a new crop rotation plan...")
  (try
    (shell "nix" "flake" "init" flake-name)
    (println "✅ Flake initialized - rotation plan ready")
    (catch Exception e
      (println (str "❌ Flake initialization failed: " (.getMessage e))))))

(defn flake-update
  "Update Nix flake inputs - like updating Helen's seed inventory"
  []
  (println "🔄 Updating Nix flake inputs...")
  (println "📦 Like Helen updating her seed inventory...")
  (try
    (shell "nix" "flake" "update")
    (println "✅ Flake inputs updated")
    (catch Exception e
      (println (str "❌ Flake update failed: " (.getMessage e))))))

(defn flake-lock
  "Generate flake lock file - like Helen recording her planting schedule"
  []
  (println "🔒 Generating flake lock file...")
  (println "📝 Like Helen recording her precise planting schedule...")
  (try
    (shell "nix" "flake" "lock")
    (println "✅ Lock file generated - schedule recorded")
    (catch Exception e
      (println (str "❌ Lock generation failed: " (.getMessage e))))))

;; ============================================================================
;; NIX DEVELOPMENT ENVIRONMENT
;; ============================================================================

(defn create-dev-environment
"Create a development environment - like Helen preparing a specific growing bed"
  [env-name packages]
  (println (str "🏗️  Creating development environment: " env-name))
  (println "🌱 Like Helen preparing a specific growing bed...")
  
  (let [shell-nix (str "shell-" env-name ".nix")
        content (str "{ pkgs ? import <nixpkgs> {} }:
pkgs.mkShell {
  buildInputs = with pkgs; [
    " (str/join "\n    " (map #(str "#{ % }") packages)) "
  ];
  
  shellHook = ''
    echo \"🌱 Entering " env-name " development environment\"
    echo \"📦 Available packages: " (str/join ", " packages) "\"
  '';
}")]
    
    (spit shell-nix content)
    (println (str "✅ Development environment created: " shell-nix))
    (println "🚀 Enter with: nix-shell " shell-nix)))

;; ============================================================================
;; NIX CONFIGURATION MANAGEMENT
;; ============================================================================

(defn generate-nix-config
  "Generate Nix configuration from EDN - like Helen creating planting plans"
  [edn-config]
  (println "📋 Generating Nix configuration from EDN...")
  (println "🌱 Like Helen creating detailed planting plans...")
  
  (let [config (edn/read-string edn-config)
        nix-content (str "{ pkgs ? import <nixpkgs> {} }:
{
  environment.systemPackages = with pkgs; [
    " (str/join "\n    " (map #(str "#{ % }") (:packages config))) "
  ];
  
  " (when (:services config)
     (str "services = {\n"
          (str/join "\n  " (map (fn [[service config]]
                                   (str service " = " config ";"))
                                (:services config)))
          "\n};\n"))
  "
  " (when (:hardware config)
     (str "hardware = {\n"
          (str/join "\n  " (map (fn [[hw config]]
                                   (str hw " = " config ";"))
                                (:hardware config)))
          "\n};\n"))
  "
}")]
    
    (spit "configuration.nix" nix-content)
    (println "✅ Nix configuration generated: configuration.nix")))

;; ============================================================================
;; NIX INTEGRATION WITH BABASHKA
;; ============================================================================

(defn babashka-nix-task
"Create a Babashka task that uses Nix - like Helen's integrated farming system"
  [task-name nix-command]
  (println (str "🔗 Creating Babashka-Nix task: " task-name))
  (println "🌱 Like Helen's integrated farming system...")
  
  (let [bb-edn-content (str "{:tasks
  {" task-name " (shell \"" nix-command "\")}}")]
    (spit "bb.edn" bb-edn-content)
    (println (str "✅ Babashka task created - run with: bb " task-name))))

(defn nix-babashka-script
"Create a Nix environment with Babashka - like Helen's complete farming toolkit"
  [script-name]
  (println (str "📜 Creating Nix-Babashka script: " script-name))
  (println "🌱 Like Helen's complete farming toolkit...")
  
  (let [script-content (str "#!/usr/bin/env nix-shell
#!nix-shell -i bash -p babashka

;; Babashka script running in Nix environment
(require '[babashka.fs :as fs])
(require '[babashka.process :refer [shell]])

(println \"🌱 Running in Nix-Babashka environment...\")
(println \"📦 Nix packages available for Babashka\")
(println \"🌾 Helen Atthowe ecological farming principles active\")")]
    
    (spit script-name script-content)
    (fs/set-posix-file-permissions script-name "rwxr-xr-x")
    (println (str "✅ Nix-Babashka script created: " script-name))))

;; ============================================================================
;; MAIN INTERFACE FUNCTIONS
;; ============================================================================

(defn show-nix-status
  "Show Nix system status - like Helen's farm inspection"
  []
  (println "🏡 NIX SYSTEM STATUS - Helen Atthowe Farm Inspection")
  (println "")
  
  ;; Check Nix installation
  (try
    (let [version (shell {:out :string} "nix" "--version")]
      (println "✅ Nix installed:")
      (println (str "   " version)))
    (catch Exception e
      (println "❌ Nix not installed or not in PATH")))
  
  ;; Check Nix store
  (try
    (let [store-info (shell {:out :string} "nix-store" "--query" "--gc-roots")]
      (println "📦 Nix store status: Active"))
    (catch Exception e
      (println "⚠️  Nix store status: Unknown")))
  
  ;; Show available channels
  (try
    (let [channels (shell {:out :string} "nix-channel" "--list")]
      (println "📚 Available channels:")
      (println channels))
    (catch Exception e
      (println "⚠️  No channels configured")))
  
  (println "")
  (println "🌱 System ready for ecological farming with Nix!"))

(defn interactive-nix-shell
  "Interactive Nix shell - like Helen's greenhouse tour"
  [packages]
  (println "🌱 Entering Interactive Nix Shell...")
  (println "🏠 Like taking a tour of Helen's greenhouse...")
  (println "")
  (println "Available packages:")
  (doseq [pkg packages]
    (println (str "  🌿 " pkg)))
  (println "")
  (println "Type 'exit' to leave the greenhouse")
  (nix-shell packages))

;; ============================================================================
;; GRATITUDE AND COMMITMENT
;; ============================================================================

(defn express-gratitude
"Express gratitude for the Nix ecosystem - like Helen's gratitude for the land"
  []
  (println "💚🖤💛 GRATITUDE FOR THE NIX ECOSYSTEM 💚🖤💛")
  (println "")
  (println "🙏 Thank you to the Nix community for building such a beautiful")
  (println "   and reproducible package management system.")
  (println "")
  (println "🌱 Like Helen Atthowe's gratitude for the land that sustains her")
  (println "   farm, we are grateful for the Nix ecosystem that sustains")
  (println "   our digital farms.")
  (println "")
  (println "🤝 This Babashka-Nix interface represents our commitment to:")
  (println "   - Reproducible builds (like Helen's consistent harvests)")
  (println "   - Functional programming (like Helen's functional ecosystems)")
  (println "   - Community sharing (like Helen's seed sharing)")
  (println "   - Sustainable practices (like Helen's no-till agriculture)")
  (println "")
  (println "💚🖤💛 Built with love for the Timid Revolution 💚🖤💛"))

;; ============================================================================
;; MAIN EXECUTION
;; ============================================================================

(defn -main
  "Main function - demonstrate the Babashka-Nix interface"
  []
  (println "💚🖤💛 BABASHKA NIX INTERFACE 💚🖤💛")
  (println "")
  (println "🌾 Helen Atthowe Ecological Farming Approach to Nix")
  (println "⏰ Timestamp: 12025-09-14--0510--pacific-daylight-standard")
  (println "")
  
  ;; Show system status
  (show-nix-status)
  
  ;; Demonstrate key functions
  (println "🔍 Demonstrating Nix operations...")
  (nix-search "clojure")
  (println "")
  
  ;; Create development environment
  (create-dev-environment "b122m-dev" ["babashka" "clojure" "nix"])
  (println "")
  
  ;; Generate Nix configuration
  (generate-nix-config "{:packages [\"babashka\" \"clojure\" \"git\"]
                       :services {:ssh {:enable true}}
                       :hardware {:opengl {:enable true}}}")
  (println "")
  
  ;; Create Babashka-Nix integration
  (babashka-nix-task "nix-search" "nix search nixpkgs")
  (nix-babashka-script "nix-babashka-example.bb")
  (println "")
  
  ;; Express gratitude
  (express-gratitude)
  
  (println "")
  (println "💚🖤💛 BABASHKA NIX INTERFACE COMPLETE 💚🖤💛")
  (println "🌱 Ready for ecological farming with Nix and Babashka!"))

;; Execute main function
(-main)
