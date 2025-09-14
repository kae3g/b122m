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
;; 💚🖤💛 FORMAT ALL FILES TO 80 CHARACTER LIMIT 💚🖤💛
;; ============================================================================
;; Recursive file formatting with correct syntax for string blocks
;; Timestamp:
12025-09-14--0552--pacific-daylight-standard--mrigashirsha--sonomausa

(ns format-all-files-80-char
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.string :as str]
            [clojure.java.io :as io]))

;; ============================================================================
;; FILE FORMATTING FUNCTIONS
;; ============================================================================

(defn format-line-to-80-chars
  "Format a single line to 80 character limit with proper syntax"
  [line]
  (if (or (str/starts-with? line " ")
          (str/includes? line ";;")
          (str/includes? line "::")
          (str/includes? line "//")
          (str/includes? line "#")
          (str/includes? line "=" (apply str (repeat 10)))
          (<= (count line) 80))
    line
    (let [words (str/split line #" ")
          lines (reduce (fn [acc word]
                          (let [current (last acc)]
                            (if (and current 
                                     (< (+ (count current) (count word) 1) 80))
                              (conj (pop acc) (str current " " word))
                              (conj acc word))))
                        [""] words)]
      (str/join "\n" lines))))

(defn rewrite-file-content
  "Rewrite file content with 80-character line limits and proper syntax"
  [content]
  (->> (str/split content #"\n")
       (map format-line-to-80-chars)
       (str/join "\n")))

(defn process-file
  "Process a single file with 80-character formatting"
  [file-path]
  (try
    (let [content (slurp file-path)
          rewritten (rewrite-file-content content)]
      (spit file-path rewritten)
      (println "✅ Formatted:" file-path))
    (catch Exception e
      (println "⚠️  Skipped:" file-path (.getMessage e)))))

(defn rewrite-repository
  "Recursively rewrite all files in repository with 80-character limits"
  [dir-path]
  (println "🌸 Rewriting all files with 80-character limits...")
  (doseq [file (file-seq (io/file dir-path))]
    (when (and (.isFile file)
               (not (str/includes? (.getPath file) ".git"))
               (not (str/includes? (.getPath file) "target"))
               (not (str/includes? (.getPath file) "bin"))
               (not (str/includes? (.getPath file) "node_modules")))
      (process-file (.getPath file)))))

;; ============================================================================
;; MAIN EXECUTION
;; ============================================================================

(defn -main
  "Main function - format all files to 80 characters"
  []
  (println "💚🖤💛 FORMATTING ALL FILES TO 80 CHARACTER LIMIT 💚🖤💛")
  (println "====================================================")
  (println "")
  (println "🌾 Helen Atthowe Ecological Farming Approach to Code Formatting")
(println "⏰ Timestamp:
12025-09-14--0552--pacific-daylight-standard--mrigashirsha--sonomausa")
  (println "")
  
  (let [workspace-dirs ["/Users/bhagavan851c05a/b122m"
                       "/Users/bhagavan851c05a/aws-eks-alpine-nix"
                       "/Users/bhagavan851c05a/maitreya"
                       "/Users/bhagavan851c05a/love-mind-soul"
                       "/Users/bhagavan851c05a/pure-code-gentle-path"]]
    
    (doseq [dir workspace-dirs]
      (when (fs/exists? dir)
        (println (str "🏡 Formatting repository: " dir))
        (rewrite-repository dir)
        (println "")))
    
    (println "💚🖤💛 ALL FILES FORMATTED TO 80 CHARACTER LIMIT 💚🖤💛")
    (println "🌱 Code formatting complete with ecological harmony")))

;; Execute main function
(-main)
