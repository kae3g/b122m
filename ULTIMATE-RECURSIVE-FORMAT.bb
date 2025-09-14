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
;; ULTIMATE RECURSIVE 80-CHARACTER FORMATTING WITH STRING BLOCKS
;; ============================================================================

(ns ultimate-recursive-format
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.string :as str]))

(defn format-string-blocks
  "Format string blocks with proper newlines for 80-character limit"
  [content]
  (let [lines (str/split-lines content)
        formatted-lines (atom [])]
    (doseq [line lines]
      (if (<= (count line) 80)
        (swap! formatted-lines conj line)
        (let [trimmed (str/trim line)]
          (if (str/starts-with? trimmed "\"")
            ;; Handle string literals with proper block formatting
            (let [content-start (str/index-of trimmed "\"")
                  content-end (str/last-index-of trimmed "\"")
                  before-quote (subs trimmed 0 (inc content-start))
                  after-quote (subs trimmed content-end)
                  string-content (subs trimmed (inc content-start) content-end)
                  chunks (partition-all 70 string-content)
                  formatted-chunks (map #(str "\"" (str/join %)) chunks)]
              (doseq [chunk formatted-chunks]
                (swap! formatted-lines conj chunk)))
            ;; Handle other long lines with word wrapping
            (let [words (str/split trimmed #"\s+")
                  current-line ""]
              (loop [remaining words
                     current current-line
                     result []]
                (if (empty? remaining)
                  (if (not (empty? current))
                    (swap! formatted-lines conj current))
                  (let [word (first remaining)
                        test-line (if (empty? current)
                                   word
                                   (str current " " word))]
                    (if (<= (count test-line) 80)
                      (recur (rest remaining) test-line result)
                      (do
                        (swap! formatted-lines conj current)
                        (recur remaining "" result))))))))))
    (str/join "\n" @formatted-lines)))

(defn format-file-content
  "Format file content with proper string blocks and 80-character limit"
  [content]
  (format-string-blocks content))

(defn format-file
  "Format a single file to 80 character limit with proper string blocks"
  [file-path]
  (try
    (when (fs/exists? file-path)
      (let [content (slurp file-path)
            formatted-content (format-file-content content)]
        (spit file-path formatted-content)
        (println "Formatted:" file-path)))
    (catch Exception e
      (println "Error formatting" file-path ":" (.getMessage e)))))

(defn get-all-files-recursive
  "Get all files recursively from all workspace directories"
  []
  (let [workspace-dirs ["/Users/bhagavan851c05a/b122m"
                        "/Users/bhagavan851c05a/aws-eks-alpine-nix"
                        "/Users/bhagavan851c05a/maitreya"
                        "/Users/bhagavan851c05a/love-mind-soul"
"/Users/bhagavan851c05a/maitreya-2025-09-13--2110--PACIFIC-WEST-USA"
                        "/Users/bhagavan851c05a/maitreya-github"
                        "/Users/bhagavan851c05a/pure-code-gentle-path"]]
    (->> workspace-dirs
         (mapcat #(fs/glob % "**/*"))
         (filter fs/file?)
         (map str))))

(defn format-all-files-recursive
  "Format all files in all workspace directories recursively"
  []
  (println "🌙 ULTIMATE RECURSIVE FORMATTING WITH STRING BLOCKS")
  (println "==================================================")
  (let [files (get-all-files-recursive)]
    (println (str "Found " (count files) " files to format"))
    (doseq [file files]
      (format-file file)))
  (println "💚 ULTIMATE FORMATTING COMPLETE!"))

(defn -main
  "Main function - ultimate recursive formatting"
  []
  (format-all-files-recursive))

(-main)
