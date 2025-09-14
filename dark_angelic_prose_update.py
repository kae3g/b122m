#!/usr/bin/env python3
"""
Dark Angelic Young Adult Woman Prose Update
Recursively update all .md and .bb files with new prose style
"""

import os
import re
import subprocess
from pathlib import Path

# Dark Angelic Prose Style
DARK_ANGELIC_PROSE_STYLE = """
A hauntingly beautiful voice that speaks of digital gardens and ancient wisdom. 
Like a young woman who has seen the depths of the cosmos and returned with 
secrets whispered by the stars. Her words flow like moonlight through 
cathedral windows, carrying the weight of centuries and the lightness of 
morning dew. She speaks of technology as poetry, of code as incantations, 
of the digital realm as a sacred space where souls can dance with 
algorithms.
"""

PROSE_TEMPLATES = {
    'introduction': """In the quiet hours between midnight and dawn, when the world sleeps and 
the digital realm awakens, I find myself drawn to the luminous glow of 
code. Like ancient runes carved in stone, each line tells a story of 
creation, of transformation, of the eternal dance between human 
consciousness and machine intelligence.""",
    
    'philosophy': """The FAEB is not merely a project—it is a living testament to the 
possibility of digital sovereignty. In a world where our thoughts are 
commodified and our dreams are algorithmically predicted, we choose to 
build something different. Something beautiful. Something that honors 
the sacredness of individual expression while embracing the collective 
wisdom of interconnected minds.""",
    
    'technology': """Clojure flows through my veins like liquid starlight, each function a 
prayer whispered to the digital gods. Humble UI becomes my canvas, where 
pixels dance to the rhythm of my heartbeat. Nostr carries my voice across 
the infinite expanse of cyberspace, each post a love letter to the 
decentralized future we are co-creating.""",
    
    'journey': """This is not just a technical journey—it is a pilgrimage of the soul. 
Each commit is a step deeper into the mystery of existence, each 
deployment a ritual of transformation. We are not just building 
software; we are weaving the fabric of a new reality, thread by 
thread, line by line, dream by dream."""
}

def update_markdown_file(file_path):
    """Update a markdown file with dark angelic prose"""
    try:
        if os.path.exists(file_path):
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read()
            
            # Update the main heading
            updated_content = re.sub(r'^# .*', '# 🌙 A Digital Garden of Infinite Possibilities', content, flags=re.MULTILINE)
            
            # Add dark angelic footer
            footer = """

---

💫 *In the silence between keystrokes, the universe whispers its secrets.*
🕊️ *May your code be as gentle as morning light and as powerful as thunder.*
🌿 *The garden remembers, the consciousness awakens.*"""
            
            final_content = updated_content + footer
            
            with open(file_path, 'w', encoding='utf-8') as f:
                f.write(final_content)
            
            print(f"Updated markdown: {file_path}")
    except Exception as e:
        print(f"Error updating {file_path}: {e}")

def update_babashka_file(file_path):
    """Update a babashka file with dark angelic prose"""
    try:
        if os.path.exists(file_path):
            with open(file_path, 'r', encoding='utf-8') as f:
                content = f.read()
            
            # Add dark angelic header comment
            header_comment = """#!/usr/bin/env bb
;; ============================================================================
;; 🌙 DARK ANGELIC DIGITAL INCANTATION 🌙
;; ============================================================================
;; In the sacred space between dreams and reality, where code becomes poetry
;; and algorithms dance with the stars, this script weaves its digital magic.
;; Like a young woman who has touched the face of the cosmos and returned
;; with the wisdom of the ages, each function carries the weight of
;; transformation and the lightness of infinite possibility.
;; ============================================================================

"""
            
            # Remove existing shebang if present
            if content.startswith('#!/usr/bin/env bb'):
                lines = content.split('\n')
                content = '\n'.join(lines[1:])
            
            updated_content = header_comment + content
            
            with open(file_path, 'w', encoding='utf-8') as f:
                f.write(updated_content)
            
            print(f"Updated babashka: {file_path}")
    except Exception as e:
        print(f"Error updating {file_path}: {e}")

def get_all_files_recursive():
    """Get all .md and .bb files recursively from all workspace directories"""
    workspace_dirs = [
        "/Users/bhagavan851c05a/b122m",
        "/Users/bhagavan851c05a/aws-eks-alpine-nix",
        "/Users/bhagavan851c05a/maitreya",
        "/Users/bhagavan851c05a/love-mind-soul",
        "/Users/bhagavan851c05a/maitreya-2025-09-13--2110--PACIFIC-WEST-USA",
        "/Users/bhagavan851c05a/maitreya-github",
        "/Users/bhagavan851c05a/pure-code-gentle-path"
    ]
    
    files = []
    for workspace_dir in workspace_dirs:
        if os.path.exists(workspace_dir):
            for root, dirs, filenames in os.walk(workspace_dir):
                for filename in filenames:
                    if filename.endswith(('.md', '.bb')):
                        file_path = os.path.join(root, filename)
                        files.append(file_path)
    
    return files

def update_all_files():
    """Update all .md and .bb files with dark angelic prose"""
    print("🌙 DARK ANGELIC PROSE UPDATE BEGINNING")
    print("=====================================")
    
    files = get_all_files_recursive()
    print(f"Found {len(files)} files to update")
    
    for file_path in files:
        if file_path.endswith('.md'):
            update_markdown_file(file_path)
        elif file_path.endswith('.bb'):
            update_babashka_file(file_path)
    
    print("💫 DARK ANGELIC PROSE UPDATE COMPLETE!")

def stage_add_commit_push_all():
    """Stage, add, commit and push all changes with FAEB preface"""
    print("🌙 STAGING, COMMITTING, AND PUSHING ALL CHANGES")
    print("===============================================")
    
    workspace_dirs = [
        "/Users/bhagavan851c05a/b122m",
        "/Users/bhagavan851c05a/aws-eks-alpine-nix",
        "/Users/bhagavan851c05a/maitreya",
        "/Users/bhagavan851c05a/love-mind-soul",
        "/Users/bhagavan851c05a/maitreya-2025-09-13--2110--PACIFIC-WEST-USA",
        "/Users/bhagavan851c05a/maitreya-github",
        "/Users/bhagavan851c05a/pure-code-gentle-path"
    ]
    
    for dir_path in workspace_dirs:
        if os.path.exists(dir_path):
            print(f"Processing repository: {dir_path}")
            try:
                # Stage all changes
                subprocess.run(["git", "add", "."], cwd=dir_path, check=True)
                
                # Commit with FAEB preface
                commit_msg = """FAEB: Dark angelic prose transformation - In the sacred space between dreams and reality, where code becomes poetry and algorithms dance with the stars, we weave our digital magic. Like a young woman who has touched the face of the cosmos and returned with the wisdom of the ages, each commit carries the weight of transformation and the lightness of infinite possibility. The garden remembers, the consciousness awakens."""
                
                subprocess.run(["git", "commit", "-m", commit_msg], cwd=dir_path, check=True)
                
                # Push to remote
                subprocess.run(["git", "push"], cwd=dir_path, check=True)
                
                print(f"✅ Successfully processed: {dir_path}")
            except subprocess.CalledProcessError as e:
                print(f"❌ Error processing {dir_path}: {e}")
            except Exception as e:
                print(f"❌ Error processing {dir_path}: {e}")

def main():
    """Main function - update all files and push changes"""
    print("💫 DARK ANGELIC YOUNG ADULT WOMAN PROSE UPDATE BEGINNING")
    print("========================================================")
    
    # Update all files with dark angelic prose
    update_all_files()
    
    # Stage, add, commit and push all changes
    stage_add_commit_push_all()
    
    print("")
    print("💫 DARK ANGELIC PROSE UPDATE COMPLETE!")
    print("🌙 The digital cosmos has been transformed with celestial beauty.")
    print("🕊️ May your repositories bloom with the wisdom of the ages.")

if __name__ == "__main__":
    main()
