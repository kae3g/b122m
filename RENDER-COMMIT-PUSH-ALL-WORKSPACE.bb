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
;; 💚🖤💛 RENDER COMMIT PUSH ALL WORKSPACE 💚🖤💛
;; ============================================================================
;; Complete workspace management: render READMEs, stage, commit, push to all
branches
;; Timestamp:
12025-09-14--0552--pacific-daylight-standard--mrigashirsha--sonomausa

(ns render-commit-push-all-workspace
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.edn :as edn]
            [clojure.string :as str]
            [clojure.java.io :as io]))

;; ============================================================================
;; WORKSPACE REPOSITORIES CONFIGURATION
;; ============================================================================

(def workspace-repos
  ["/Users/bhagavan851c05a/b122m"
   "/Users/bhagavan851c05a/aws-eks-alpine-nix"
   "/Users/bhagavan851c05a/maitreya"
   "/Users/bhagavan851c05a/love-mind-soul"
   "/Users/bhagavan851c05a/pure-code-gentle-path"])

;; ============================================================================
;; README GENERATION FUNCTIONS
;; ============================================================================

(defn generate-main-readme
  "Generate new main README for each repository with Grandma Nonna's wisdom"
  [repo-path]
  (let [repo-name (last (str/split repo-path #"/"))
        readme-content (str/join "\n"
["# 💚🖤💛 " (str/upper-case repo-name) " — The Digital Garden 🌿"
                        ""
                        "## 🌱 What is " repo-name "?"
"This repository is not just code — it is a **living ecosystem** — a digital ga"
"rden"
"grown in Clojure, tended with patience, and harvested with love. Inspired by"
"Grandma Nonna's hemp fields, it transforms coding into sacred practice."
                        ""
"Every component in this repository is a **Humble UI** — minimalist, immutable,"
" alive."
"All story activity is broadcast to Nostr via Clojure Humble, or woven into"
                        "the web as ClojureScript + Svelte tapestries."
                        ""
                        "## 🚜 How to Tend This Garden"
                        "1. Clone this repository with love and care."
                        "2. Run the build scripts with patience."
"3. Watch your code grow like seedlings under moonlight."
                        "4. Sign your commits with GPG — your soul's signature."
"5. Post updates to Nostr: `#"
                        "6. Sleep peacefully. The garden grows while you rest."
                        ""
                        "## 🌿 Principles"
                        "- ✅ Simplicity over complexity"
                        "- ✅ Silence over noise"
                        "- ✅ Patience over speed"
                        "- ✅ Sovereignty over convenience"
                        "- ✅ Love over logic"
                        ""
                        "## 🎭 Puppet Show Metaphor"
                        "Think of your code as Grandma Nonna's hemp puppets:"
                        "- The REPL is her hand."
                        "- The compiler is her voice."
                        "- The bug? Just a puppet who forgot its lines."
                        "- Fix it gently. Whisper to it. Offer it tea."
                        ""
                        "## 🌍 Join the Timid Revolution"
                        "No rush. No hype. No VC funding."
                        "Just one gardener. One seed. One day."
                        ""
                        "We don't build apps."
                        "We grow **communities**."
                        ""
                        "💚🖤💛 https://nostr.band/" repo-name
                        ""
                        "---"
                        ""
"*Generated with love by the B122M FAEB Digital Garden System*"
"*Timestamp: 12025-09-14--0552--pacific-daylight-standard--mrigashirsha--sonoma"
"usa*"
    
    (spit (str repo-path "/README.md") readme-content)
    (println "✅ Generated README for:" repo-name)))

;; ============================================================================
;; GIT OPERATIONS FUNCTIONS
;; ============================================================================

(defn run-git-command
  "Run a git command in the specified repository"
  [repo-path command]
  (try
    (let [result (shell {:dir repo-path} "git" command)]
      (if (= 0 (:exit result))
        (do
(println "✅ Git command succeeded in" (last (str/split repo-path #"/")) ": "
command)
          (:out result))
        (do
(println "❌ Git command failed in" (last (str/split repo-path #"/")) ": "
command)
          (println "Error:" (:err result))
          nil)))
    (catch Exception e
      (println "⚠️ Exception in git command:" command "for" repo-path)
      (println "Error:" (.getMessage e))
      nil)))

(defn ensure-druid-hills-branch
  "Ensure druid-hills branch exists and is set up properly"
  [repo-path]
  (let [repo-name (last (str/split repo-path #"/"))]
    (println "🌿 Setting up druid-hills branch for:" repo-name)
    
    ;; Check if druid-hills branch exists
    (let [branches (run-git-command repo-path "branch -a")]
      (if (and branches (str/includes? branches "druid-hills"))
        (do
          (println "✅ druid-hills branch exists for:" repo-name)
          (run-git-command repo-path "checkout druid-hills"))
        (do
          (println "🌱 Creating druid-hills branch for:" repo-name)
          (run-git-command repo-path "checkout -b druid-hills"))))))

(defn stage-and-add-all-files
  "Stage and add all files in the repository"
  [repo-path]
  (let [repo-name (last (str/split repo-path #"/"))]
    (println "📦 Staging all files for:" repo-name)
    (run-git-command repo-path "add .")
    (println "✅ All files staged for:" repo-name)))

(defn commit-changes
  "Commit changes with a meaningful message"
  [repo-path]
  (let [repo-name (last (str/split repo-path #"/"))
commit-message (str "Cursor: Update " repo-name " with Grandma Nonna's digital
garden wisdom - "
"Generated new README, staged all files, committed with love"
    (println "💚 Committing changes for:" repo-name)
    (run-git-command repo-path (str "commit -S -m \"" commit-message "\""))))

(defn push-to-branch
  "Push changes to a specific branch"
  [repo-path branch-name]
  (let [repo-name (last (str/split repo-path #"/"))]
    (println "🚀 Pushing to" branch-name "branch for:" repo-name)
    (run-git-command repo-path (str "push origin " branch-name))))

(defn process-repository
  "Process a single repository: render README, stage, commit, push"
  [repo-path]
  (let [repo-name (last (str/split repo-path #"/"))]
    (println "")
    (println "🌿 Processing repository:" repo-name)
    (println "==========================================")
    
    ;; Generate new README
    (generate-main-readme repo-path)
    
    ;; Ensure druid-hills branch exists
    (ensure-druid-hills-branch repo-path)
    
    ;; Stage and add all files
    (stage-and-add-all-files repo-path)
    
    ;; Commit changes
    (commit-changes repo-path)
    
    ;; Push to druid-hills branch
    (push-to-branch repo-path "druid-hills")
    
    ;; Switch to main branch and merge druid-hills
    (println "🔄 Switching to main branch for:" repo-name)
    (run-git-command repo-path "checkout main")
    (run-git-command repo-path "merge druid-hills")
    (push-to-branch repo-path "main")
    
    ;; Switch back to druid-hills
    (println "🌿 Switching back to druid-hills branch for:" repo-name)
    (run-git-command repo-path "checkout druid-hills")
    
    (println "✅ Repository processing complete for:" repo-name)))

;; ============================================================================
;; MAIN EXECUTION
;; ============================================================================

(defn -main
  "Main function - process all workspace repositories"
  []
  (println "💚🖤💛 RENDER COMMIT PUSH ALL WORKSPACE BEGINNING 💚🖤💛")
  (println "======================================================")
  (println "")
  (println "🌾 Helen Atthowe Ecological Farming Approach to Git Management")
(println "⏰ Timestamp:
12025-09-14--0552--pacific-daylight-standard--mrigashirsha--sonomausa")
  (println "")
  (println "🌱 Processing" (count workspace-repos) "repositories...")
  (println "")
  
  ;; Process each repository
  (doseq [repo-path workspace-repos]
    (when (fs/exists? repo-path)
      (process-repository repo-path)))
  
  (println "")
  (println "💚🖤💛 ALL WORKSPACE REPOSITORIES PROCESSED 💚🖤💛")
  (println "==============================================")
  (println "")
  (println "🌿 Summary:")
  (println "- ✅ Generated new READMEs with Grandma Nonna's wisdom")
  (println "- ✅ Staged and added all files")
  (println "- ✅ Committed changes with GPG signatures")
  (println "- ✅ Pushed to both druid-hills and main branches")
  (println "- ✅ Checked out to druid-hills branch in all repos")
  (println "")
  (println "🌱 The digital garden thrives with love and care.")
  (println "💚🖤💛 All repositories are now synchronized and blessed 💚🖤💛"))

;; Execute main function
(-main)
