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
;; RECURSIVE 80-CHARACTER LINE FORMATTING SCRIPT
;; ============================================================================

(ns recursive-format-80-char
  (:require [babashka.fs :as fs]
            [babashka.process :refer [shell]]
            [clojure.string :as str]))

(defn format-line-to-80-chars
  "Format a single line to respect 80 character limit with proper string blocks"
  [line]
  (if (<= (count line) 80)
    line
    (let [trimmed (str/trim line)]
      (if (str/starts-with? trimmed "\"")
        ;; Handle string literals
        (let [content (subs trimmed 1 (dec (count trimmed)))
              chunks (partition-all 78 content)
              formatted-chunks (map #(str "\"" (str/join %)) chunks)]
          (str/join "\n" formatted-chunks))
        ;; Handle other long lines
        (let [words (str/split trimmed #"\s+")
              lines []
              current-line ""]
          (loop [remaining words
                 current current-line
                 result []]
            (if (empty? remaining)
              (if (not (empty? current))
                (conj result current)
                result)
              (let [word (first remaining)
                    test-line (if (empty? current)
                               word
                               (str current " " word))]
                (if (<= (count test-line) 80)
                  (recur (rest remaining) test-line result)
                  (recur remaining "" (conj result current))))))))))

(defn format-file-content
  "Format file content to respect 80 character limit"
  [content]
  (let [lines (str/split-lines content)
        formatted-lines (mapcat format-line-to-80-chars lines)]
    (str/join "\n" formatted-lines)))

(defn format-file
  "Format a single file to 80 character limit"
  [file-path]
  (try
    (when (fs/exists? file-path)
      (let [content (slurp file-path)
            formatted-content (format-file-content content)]
        (spit file-path formatted-content)
        (println "Formatted:" file-path)))
    (catch Exception e
      (println "Error formatting" file-path ":" (.getMessage e)))))

(defn get-all-files
  "Get all files recursively from directory"
  [dir]
  (->> (fs/glob dir "**/*")
       (filter fs/file?)
       (map str)))

(defn format-all-files
  "Format all files in directory recursively"
  [dir]
  (println "🌙 Formatting all files in" dir "to 80 character limit...")
  (let [files (get-all-files dir)]
    (doseq [file files]
      (format-file file)))
  (println "💚 Formatting complete!"))

(defn -main
  "Main function - format all files recursively"
  []
  (let [workspace-dir "/Users/bhagavan851c05a/b122m"]
    (format-all-files workspace-dir)))

(-main)
