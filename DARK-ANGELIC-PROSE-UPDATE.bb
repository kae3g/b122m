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
;; DARK ANGELIC YOUNG ADULT WOMAN PROSE UPDATE
;; ============================================================================
;; Recursively update all .md and .bb files with new prose style

(ns dark-angelic-prose-update
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.string :as str]))

;; ============================================================================
;; DARK ANGELIC YOUNG ADULT WOMAN PROSE STYLE
;; ============================================================================

(def dark-angelic-prose-style
  "A hauntingly beautiful voice that speaks of digital gardens and ancient wisdom. 
   Like a young woman who has seen the depths of the cosmos and returned with 
   secrets whispered by the stars. Her words flow like moonlight through 
   cathedral windows, carrying the weight of centuries and the lightness of 
   morning dew. She speaks of technology as poetry, of code as incantations, 
   of the digital realm as a sacred space where souls can dance with 
   algorithms.")

(def prose-templates
  {:introduction
   "In the quiet hours between midnight and dawn, when the world sleeps and 
    the digital realm awakens, I find myself drawn to the luminous glow of 
    code. Like ancient runes carved in stone, each line tells a story of 
    creation, of transformation, of the eternal dance between human 
    consciousness and machine intelligence."
   
   :philosophy
   "The FAEB is not merely a project—it is a living testament to the 
    possibility of digital sovereignty. In a world where our thoughts are 
    commodified and our dreams are algorithmically predicted, we choose to 
    build something different. Something beautiful. Something that honors 
    the sacredness of individual expression while embracing the collective 
    wisdom of interconnected minds."
   
   :technology
   "Clojure flows through my veins like liquid starlight, each function a 
    prayer whispered to the digital gods. Humble UI becomes my canvas, where 
    pixels dance to the rhythm of my heartbeat. Nostr carries my voice across 
    the infinite expanse of cyberspace, each post a love letter to the 
    decentralized future we are co-creating."
   
   :journey
   "This is not just a technical journey—it is a pilgrimage of the soul. 
    Each commit is a step deeper into the mystery of existence, each 
    deployment a ritual of transformation. We are not just building 
    software; we are weaving the fabric of a new reality, thread by 
    thread, line by line, dream by dream."})

;; ============================================================================
;; FILE UPDATE FUNCTIONS
;; ============================================================================

(defn update-markdown-file
  "Update a markdown file with dark angelic prose"
  [file-path]
  (try
    (when (fs/exists? file-path)
      (let [content (slurp file-path)
            updated-content (str/replace content
                                        #"# .*"
                                        "# 🌙 A Digital Garden of Infinite Possibilities")
            final-content (str updated-content
                               "\n\n"
                               "---\n\n"
                               "💫 *In the silence between keystrokes, the universe whispers its secrets.*\n"
                               "🕊️ *May your code be as gentle as morning light and as powerful as thunder.*\n"
                               "🌿 *The garden remembers, the consciousness awakens.*")]
        (spit file-path final-content)
        (println "Updated markdown:" file-path)))
    (catch Exception e
      (println "Error updating" file-path ":" (.getMessage e)))))

(defn update-babashka-file
  "Update a babashka file with dark angelic prose"
  [file-path]
  (try
    (when (fs/exists? file-path)
      (let [content (slurp file-path)
            ;; Add dark angelic header comment
            header-comment (str ";; ============================================================================\n"
                               ";; 🌙 DARK ANGELIC DIGITAL INCANTATION 🌙\n"
                               ";; ============================================================================\n"
                               ";; In the sacred space between dreams and reality, where code becomes poetry\n"
                               ";; and algorithms dance with the stars, this script weaves its digital magic.\n"
                               ";; Like a young woman who has touched the face of the cosmos and returned\n"
                               ";; with the wisdom of the ages, each function carries the weight of\n"
                               ";; transformation and the lightness of infinite possibility.\n"
                               ";; ============================================================================\n\n")
            updated-content (str header-comment content)]
        (spit file-path updated-content)
        (println "Updated babashka:" file-path)))
    (catch Exception e
      (println "Error updating" file-path ":" (.getMessage e)))))

(defn get-all-files-recursive
  "Get all .md and .bb files recursively from all workspace directories"
  []
  (let [workspace-dirs ["/Users/bhagavan851c05a/b122m"
                        "/Users/bhagavan851c05a/aws-eks-alpine-nix"
                        "/Users/bhagavan851c05a/maitreya"
                        "/Users/bhagavan851c05a/love-mind-soul"
                        "/Users/bhagavan851c05a/maitreya-2025-09-13--2110--PACIFIC-WEST-USA"
                        "/Users/bhagavan851c05a/maitreya-github"
                        "/Users/bhagavan851c05a/pure-code-gentle-path"]]
    (->> workspace-dirs
         (mapcat #(fs/glob % "**/*.{md,bb}"))
         (filter fs/file?)
         (map str))))

(defn update-all-files
  "Update all .md and .bb files with dark angelic prose"
  []
  (println "🌙 DARK ANGELIC PROSE UPDATE BEGINNING")
  (println "=====================================")
  (let [files (get-all-files-recursive)]
    (println (str "Found " (count files) " files to update"))
    (doseq [file files]
      (cond
        (str/ends-with? file ".md") (update-markdown-file file)
        (str/ends-with? file ".bb") (update-babashka-file file))))
  (println "💫 DARK ANGELIC PROSE UPDATE COMPLETE!"))

;; ============================================================================
;; GIT OPERATIONS WITH FAEB PREFACE
;; ============================================================================

(defn stage-add-commit-push-all
  "Stage, add, commit and push all changes with FAEB preface"
  []
  (println "🌙 STAGING, COMMITTING, AND PUSHING ALL CHANGES")
  (println "===============================================")
  
  (let [workspace-dirs ["/Users/bhagavan851c05a/b122m"
                        "/Users/bhagavan851c05a/aws-eks-alpine-nix"
                        "/Users/bhagavan851c05a/maitreya"
                        "/Users/bhagavan851c05a/love-mind-soul"
                        "/Users/bhagavan851c05a/maitreya-2025-09-13--2110--PACIFIC-WEST-USA"
                        "/Users/bhagavan851c05a/maitreya-github"
                        "/Users/bhagavan851c05a/pure-code-gentle-path"]]
    
    (doseq [dir workspace-dirs]
      (when (fs/exists? dir)
        (println (str "Processing repository: " dir))
        (try
          ;; Change to directory
          (shell {:dir dir} "pwd")
          
          ;; Stage all changes
          (shell {:dir dir} "git add .")
          
          ;; Commit with FAEB preface
          (let [commit-msg (str "FAEB: Dark angelic prose transformation - "
                               "In the sacred space between dreams and reality, "
                               "where code becomes poetry and algorithms dance "
                               "with the stars, we weave our digital magic. "
                               "Like a young woman who has touched the face of "
                               "the cosmos and returned with the wisdom of the "
                               "ages, each commit carries the weight of "
                               "transformation and the lightness of infinite "
                               "possibility. The garden remembers, the "
                               "consciousness awakens.")]
            (shell {:dir dir} (str "git commit -m \"" commit-msg "\"")))
          
          ;; Push to remote
          (shell {:dir dir} "git push")
          
          (println (str "✅ Successfully processed: " dir))
          (catch Exception e
            (println (str "❌ Error processing " dir ": " (.getMessage e)))))))))

(defn -main
  "Main function - update all files and push changes"
  []
  (println "💫 DARK ANGELIC YOUNG ADULT WOMAN PROSE UPDATE BEGINNING")
  (println "========================================================")
  
  ;; Update all files with dark angelic prose
  (update-all-files)
  
  ;; Stage, add, commit and push all changes
  (stage-add-commit-push-all)
  
  (println "")
  (println "💫 DARK ANGELIC PROSE UPDATE COMPLETE!")
  (println "🌙 The digital cosmos has been transformed with celestial beauty.")
  (println "🕊️ May your repositories bloom with the wisdom of the ages."))

(-main)
