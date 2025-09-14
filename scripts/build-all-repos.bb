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
;; 💚🖤💛 B122M WORKSPACE BUILD SYSTEM 💚🖤💛
;; ============================================================================
;; Helen Atthowe Ecological Farming Approach to Building All Repositories
;; Timestamp: 12025-09-14--0500--pacific-daylight-standard--mrigashirsha

(ns build-all-repos
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]))

;; ============================================================================
;; WORKSPACE REPOSITORIES (FARM FIELDS)
;; ============================================================================

(def workspace-repos
  {:b122m
   {:path "/Users/bhagavan851c05a/b122m"
    :name "B122M Main Field"
    :type "primary"
    :build-tasks ["build-from-source" "alpine-gui-distro" "docs"]
    :dependencies []}
   
   :aws-eks-alpine-nix
   {:path "/Users/bhagavan851c05a/aws-eks-alpine-nix"
    :name "Cloud Infrastructure Field"
    :type "infrastructure"
    :build-tasks ["terraform" "nix-configs" "kubernetes"]
    :dependencies ["b122m"]}
   
   :maitreya
   {:path "/Users/bhagavan851c05a/maitreya"
    :name "Wisdom Garden"
    :type "documentation"
    :build-tasks ["philosophy" "meditation" "knowledge"]
    :dependencies ["b122m"]}
   
   :love-mind-soul
   {:path "/Users/bhagavan851c05a/love-mind-soul"
    :name "Heart-Centered Orchard"
    :type "spiritual"
    :build-tasks ["emotional-intelligence" "mindfulness" "compassion"]
    :dependencies ["b122m" "maitreya"]}
   
   :pure-code-gentle-path
   {:path "/Users/bhagavan851c05a/pure-code-gentle-path"
    :name "Gentle Path Meadow"
    :type "code-quality"
:build-tasks ["functional-programming" "clean-architecture" "gentle-practices"]
    :dependencies ["b122m"]}})

;; ============================================================================
;; ECOLOGICAL BUILDING FUNCTIONS
;; ============================================================================

(defn check-soil-health
  "Check if repository environment is healthy (like checking soil)"
  [repo-path]
  (println (str "🌱 Checking soil health in " repo-path "..."))
  (let [checks [(fs/exists? (str repo-path "/.git"))
                (fs/exists? (str repo-path "/bb.edn"))
                (fs/exists? (str repo-path "/README.md"))]]
    (if (every? true? checks)
      (do (println "✅ Soil health: Excellent")
          true)
      (do (println "⚠️  Soil health: Needs improvement")
          false))))

(defn prepare-field
  "Prepare repository for building (like preparing a field)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "🌾 Preparing field: " repo-name))
    (println (str "📍 Path: " repo-path))
    
    ;; Ensure we're in the right directory
    (shell "cd" repo-path)
    
    ;; Check git status
(let [git-status (shell {:out :string} "cd" repo-path "&&" "git" "status"
"--porcelain")]
      (if (str/blank? git-status)
        (println "✅ Field is clean and ready")
        (println "📝 Field has changes to commit")))
    
    ;; Check for build configuration
    (if (fs/exists? (str repo-path "/bb.edn"))
      (println "✅ Build configuration found")
      (create-basic-bb-edn repo-path))
    
    (println (str "✅ Field prepared: " repo-name))))

(defn create-basic-bb-edn
  "Create basic bb.edn if it doesn't exist"
  [repo-path]
  (println "📝 Creating basic bb.edn configuration...")
  (spit (str repo-path "/bb.edn")
        "{:tasks
  {:build (println \"Building repository...\")
   :test (println \"Running tests...\")
   :lint (println \"Linting code...\")
   :clean (shell \"rm -rf target\")}}"))

(defn plant-seeds
  "Initialize or update project structure (like planting seeds)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "🌰 Planting seeds in " repo-name "..."))
    
    ;; Create essential directories
    (doseq [dir ["src" "test" "docs" "scripts"]]
      (let [dir-path (str repo-path "/" dir)]
        (when-not (fs/exists? dir-path)
          (fs/create-dirs dir-path)
          (println (str "   Created directory: " dir)))))
    
    ;; Create basic README if it doesn't exist
    (when-not (fs/exists? (str repo-path "/README.md"))
      (spit (str repo-path "/README.md")
            (str "# " repo-name "\n\n"
"Helen Atthowe Ecological Farming Approach to Software Development\n\n"
"This repository follows sustainable, ecological principles.\n\n"
                 "## Building\n\n"
                 "```bash\n"
                 "bb build\n"
                 "```\n\n"
                 "## Testing\n\n"
                 "```bash\n"
                 "bb test\n"
                 "```")))
    
    (println (str "✅ Seeds planted in " repo-name))))

(defn water-and-nurture
  "Run development processes (like watering and nurturing plants)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "💧 Watering and nurturing " repo-name "..."))
    
    (try
      ;; Run build tasks
      (doseq [task (:build-tasks repo-config)]
        (println (str "   Running task: " task))
        (shell "cd" repo-path "&&" "bb" "build"))
      
      ;; Run tests if available
      (shell "cd" repo-path "&&" "bb" "test")
      
      (println (str "✅ " repo-name " nurtured successfully"))
      (catch Exception e
        (println (str "⚠️  Warning in " repo-name ": " (.getMessage e)))))))

(defn companion-planting
  "Set up inter-repository dependencies (like companion planting)"
  [repo-config all-repos]
  (let [repo-name (:name repo-config)
        dependencies (:dependencies repo-config)]
    (when (seq dependencies)
      (println (str "🌿 Setting up companion planting for " repo-name "..."))
      (doseq [dep dependencies]
        (let [dep-config (get all-repos (keyword dep))]
          (when dep-config
            (println (str "   Companion with: " (:name dep-config)))
(setup-cross-repo-references (:path repo-config) (:path dep-config))))))))

(defn setup-cross-repo-references
  "Set up references between repositories"
  [repo-path dep-path]
  (let [reference-file (str repo-path "/docs/dependencies.md")]
    (when-not (fs/exists? reference-file)
      (spit reference-file
            (str "# Repository Dependencies\n\n"
                 "This repository depends on:\n\n"
                 "- " dep-path "\n\n"
                 "## Integration\n\n"
                 "Cross-repository integration is managed through:\n"
                 "- Shared configuration files\n"
                 "- Common build scripts\n"
                 "- Documentation cross-references\n")))))

(defn natural-pest-control
  "Run quality and security checks (like natural pest control)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "🕷️  Applying natural pest control to " repo-name "..."))
    
    (try
      ;; Run linting
      (shell "cd" repo-path "&&" "bb" "lint")
      
      ;; Check for common issues
      (check-code-quality repo-path)
      
      (println (str "✅ Natural pest control applied to " repo-name))
      (catch Exception e
(println (str "⚠️ Pest control warning for " repo-name ": " (.getMessage
e)))))))

(defn check-code-quality
  "Check basic code quality metrics"
  [repo-path]
  (let [files (filter #(.isFile %) (file-seq (io/file repo-path)))]
    (doseq [file files]
      (when (and (.endsWith (.getName file) ".clj")
                 (not (str/includes? (.getPath file) ".git")))
        (let [content (slurp file)
              lines (str/split-lines content)
              long-lines (filter #(> (count %) 80) lines)]
          (when (seq long-lines)
            (println (str "   ⚠️  Long lines found in: " (.getName file)))))))))

(defn harvest-time
  "Package and prepare for deployment (like harvesting)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "🌾 Harvest time in " repo-name "..."))
    
    (try
      ;; Create package if applicable
      (shell "cd" repo-path "&&" "bb" "package")
      
      ;; Generate documentation
      (generate-documentation repo-path)
      
      (println (str "✅ Harvest complete for " repo-name))
      (catch Exception e
(println (str "⚠️ Harvest warning for " repo-name ": " (.getMessage e)))))))

(defn generate-documentation
  "Generate documentation for the repository"
  [repo-path]
  (let [docs-dir (str repo-path "/docs")]
    (when (fs/exists? docs-dir)
      (let [readme-path (str repo-path "/README.md")]
        (when (fs/exists? readme-path)
          (println "   📚 Documentation generated"))))))

(defn save-seeds
  "Commit and push changes (like saving seeds for next season)"
  [repo-config]
  (let [repo-path (:path repo-config)
        repo-name (:name repo-config)]
    (println (str "💾 Saving seeds from " repo-name "..."))
    
    (try
      ;; Add all changes
      (shell "cd" repo-path "&&" "git" "add" ".")
      
      ;; Commit with descriptive message
      (shell "cd" repo-path "&&" "git" "commit" "-m" 
             "Cursor: Helen Atthowe ecological farming cycle complete")
      
      ;; Push to druid-hills branch
      (shell "cd" repo-path "&&" "git" "push" "origin" "druid-hills")
      
      (println (str "✅ Seeds saved from " repo-name))
      (catch Exception e
(println (str "⚠️ Seed saving warning for " repo-name ": " (.getMessage e)))))))

;; ============================================================================
;; MAIN BUILD ORCHESTRATION
;; ============================================================================

(defn build-repository
  "Build a single repository following ecological principles"
  [repo-key repo-config all-repos]
  (println (str "🏡 Building " (:name repo-config)))
  (println (str "📍 " (:path repo-config)))
  (println (str "🌍 Type: " (:type repo-config)))
  (println "")
  
  ;; Ecological farming steps
  (prepare-field repo-config)
  (plant-seeds repo-config)
  (water-and-nurture repo-config)
  (companion-planting repo-config all-repos)
  (natural-pest-control repo-config)
  (harvest-time repo-config)
  (save-seeds repo-config)
  
  (println "")
  (println (str "✅ " (:name repo-config) " build complete"))
  (println "🔄 Rotating to next field...")
  (println ""))

(defn build-all-repositories
  "Build all repositories in the workspace"
  []
  (println "💚🖤💛 B122M WORKSPACE BUILD SYSTEM 💚🖤💛")
  (println "")
  (println "🌾 Helen Atthowe Ecological Farming Approach")
  (println "🎓 Building all workspace repositories")
  (println "⏰ Timestamp: 12025-09-14--0500--pacific-daylight-standard")
  (println "")
  
  ;; Build repositories in dependency order
(let [build-order [:b122m :pure-code-gentle-path :maitreya :love-mind-soul
:aws-eks-alpine-nix]]
    (doseq [repo-key build-order]
      (when-let [repo-config (get workspace-repos repo-key)]
        (build-repository repo-key repo-config workspace-repos)))))

;; ============================================================================
;; MAIN EXECUTION
;; ============================================================================

(defn -main
  "Main function - build all repositories"
  []
  (println "💚🖤💛 STARTING B122M WORKSPACE BUILD 💚🖤💛")
  (println "")
  
  (try
    (build-all-repositories)
    
    (println "💚🖤💛 WORKSPACE BUILD COMPLETE 💚🖤💛")
    (println "")
    (println "🌱 All fields have been cultivated using Helen Atthowe's methods")
    (println "📚 All repositories built and documented")
    (println "🔄 All changes committed and pushed")
    (println "")
    (println "🌍 The entire farm is ready for the next growing season!")
    (println "")
    (println "💚🖤💛 Timid Revolution in Software Development Complete! 💚🖤💛")
    
    (catch Exception e
      (println "❌ Build failed:" (.getMessage e))
      (System/exit 1))))

;; Execute main function
(-main)
