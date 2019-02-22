func countSubstrings(s string) int {
    result := 0
    
    for i := 0; i < len(s) * 2; i++ {
        for left, right := i / 2, (i + 1) / 2; left >= 0 && right < len(s) && s[left] == s[right]; left, right = left - 1, right + 1 {
            result++
        }
    }
    
    return result
}
