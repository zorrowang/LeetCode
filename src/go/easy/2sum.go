func twoSum(nums []int, target int) []int {
    dict := make(map[int]int)
    for i, num := range nums {
        dict[num] = i
    }
    ret := make([]int, 2)
    for i, num := range nums {
        if val, ok := dict[target-num]; ok {
            if val != i {
                ret[0] = i
                ret[1] = val
                break
            }
        }
    }
    return ret
}