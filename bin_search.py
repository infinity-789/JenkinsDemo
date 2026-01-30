def binary_search(arr, s):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = low + (high - low) // 2

        if arr[mid] < s:
            low = mid + 1
        elif arr[mid] > s:
            high = mid - 1
        else:
            return mid
    return 0

arr = [1, 2, 3, 4]
s = 2
result = binary_search(arr, s)

if result != 0:
    print("Element is present in the array")
else:
    print("Element is not present in array")
