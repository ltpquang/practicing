package _go

import (
	"slices"
)

func maximumLength(nums []int) int {
	var evenResultMap = make(map[int]int)
	var oddResultMap = make(map[int]int)

	if len(nums) == 0 {
		return 0
	}

	oddsCount := 0
	evensCount := 0

	for _, v := range nums {
		if v%2 == 0 {
			evensCount += 1
		} else {
			oddsCount += 1
		}
	}

	maxFirstOdd := maximumLengthWithFirstOdd(0, nums, oddResultMap, evenResultMap)
	maxFirstEven := maximumLengthWithFirstEven(0, nums, oddResultMap, evenResultMap)

	arr := []int{oddsCount, evensCount, maxFirstOdd, maxFirstEven}
	slices.Sort(arr)
	return arr[len(arr)-1]
}

func maximumLengthWithFirstOdd(index int, nums []int, oddMap map[int]int, evenMap map[int]int) int {
	cached, exist := oddMap[index]
	if exist {
		return cached
	}

	if len(nums) == 0 {
		return 0
	}

	maxSubOdd := maximumLengthWithFirstOdd(index+1, nums[1:], oddMap, evenMap)
	if nums[0]%2 == 0 { // even
		setCache(oddMap, index, maxSubOdd)
		return maxSubOdd
	}

	maxSubEven := maximumLengthWithFirstEven(index+1, nums[1:], oddMap, evenMap)

	if maxSubOdd > maxSubEven+1 {
		setCache(oddMap, index, maxSubOdd)
		return maxSubOdd
	} else {
		setCache(oddMap, index, maxSubEven+1)
		return maxSubEven + 1
	}
}

func maximumLengthWithFirstEven(index int, nums []int, oddMap map[int]int, evenMap map[int]int) int {
	cached, exist := evenMap[index]
	if exist {
		return cached
	}

	if len(nums) == 0 {
		return 0
	}

	maxSubEven := maximumLengthWithFirstEven(index+1, nums[1:], oddMap, evenMap)
	if nums[0]%2 != 0 { // odd
		setCache(evenMap, index, maxSubEven)
		return maxSubEven
	}

	maxSubOdd := maximumLengthWithFirstOdd(index+1, nums[1:], oddMap, evenMap)

	if maxSubEven > maxSubOdd+1 {
		setCache(evenMap, index, maxSubEven)
		return maxSubEven
	} else {
		setCache(evenMap, index, maxSubOdd+1)
		return maxSubOdd + 1
	}
}

func setCache(data map[int]int, index int, value int) map[int]int {
	cur := data[index]
	if cur < value {
		data[index] = value
	}
	return data
}
