
def pivot(array):
    j = 0
    for i in range(len(array)):
        if array[i] < 6:
            array[j], array[i] = array[i], array[j]
            j += 1
