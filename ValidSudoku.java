class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];
        for(int j=0;j<n;j++){
            rows[j] = new HashSet<Character>();
            cols[j] = new HashSet<Character>();
            box[j] = new HashSet<Character>();
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                char val = board[r][c];
                if(val == '.'){
                    continue;
                }
                if(rows[r].contains(val)){
                    return false;
                }
                rows[r].add(val);
                if(cols[c].contains(val)){
                    return false;
                }
                cols[c].add(val);
                int i = (r/3) *3 + c/3;
                if(box[i].contains(val)){
                    return false;
                }
                box[i].add(val);
            }
        }
        return true;
    }
}



🧠 Valid Sudoku – Simple Explanation

The goal is to check whether a Sudoku board follows the rules.

Each row, column, and 3×3 box must contain digits 1–9 without repetition.

Empty cells (.) are ignored.

🧱 Data Structures Used

rows[9] → stores digits already seen in each row

cols[9] → stores digits already seen in each column

box[9] → stores digits already seen in each 3×3 sub-box

Each index contains a HashSet, which helps detect duplicates quickly.

🔁 Step-by-Step Logic
1️⃣ Initialize HashSets
for(int j = 0; j < 9; j++){
    rows[j] = new HashSet<>();
    cols[j] = new HashSet<>();
    box[j]  = new HashSet<>();
}


👉 Creates empty HashSets so we can safely store values.

2️⃣ Traverse the Board
for each cell (r, c)


Read the current cell value.

If it is ., skip it.

3️⃣ Row Check
if(rows[r].contains(val)) return false;
rows[r].add(val);


👉 Ensures no duplicate digit exists in the same row.

4️⃣ Column Check
if(cols[c].contains(val)) return false;
cols[c].add(val);


👉 Ensures no duplicate digit exists in the same column.

5️⃣ 3×3 Box Check
int i = (r / 3) * 3 + (c / 3);
if(box[i].contains(val)) return false;
box[i].add(val);


👉 Calculates which 3×3 box the cell belongs to and checks for duplicates.

📌 Box Index Formula (Important)
(r / 3) * 3 + (c / 3)


Maps every cell to a box number from 0 to 8.

✅ Final Result

If no duplicates are found → return true

If any rule is violated → return false
