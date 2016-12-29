# Heath Baron-Morgan

import random
import time
   
def linearInsertionSort(aList):
    '''
    Standard insertion sort (using linear search)
    '''
    start = time.time()
    for currentPosition in range(1, len(aList)):
        currentValue = aList[currentPosition]
        position = currentPosition
        while position > 0 and aList[position - 1] > currentValue:
            aList[position] = aList[position - 1]
            position = position - 1
        aList[position] = currentValue
    elapsed = time.time() - start
    print('linearInsertionSort:', len(aList), 'items =', "%.4f" % elapsed,
          'seconds')


def testSortPerformance(sortFunction, noOfSamples):
    print()
    print('Testing sorting performance at different sample sizes')
    print()
    
    sampleSize = 200
    for sample in range(noOfSamples):

        # Create an unsorted list of random integers 
        testList = []
        for i in range(sampleSize):
           testList.append(random.randrange(0, sampleSize))
        
        sortFunction(testList)
        
        sampleSize = sampleSize * 2     # the next sample has double the size

noOfSamples = 1
testSortPerformance(linearInsertionSort, noOfSamples)

# --------------

def recursiveBinarySearch(aList, first, last, target):
    assert 0 <= first < len(aList)  # Checks if first is valid
    assert last < len(aList)  # Checks if last is valid
    assert sorted(aList) == aList  # Checks if the list is in assending order
        
    pos = (first + last) // 2  # Aquire new pos

    if first > last: # Return appropriate pos in a first and last crossover (DEFENSIVE)
        if aList[pos] > target:
            return pos 
        else:
            return pos + 1
    else:
        if aList[pos] == target:
            return pos  # Target found, return pos
        elif len(aList[first:last]) == 0: # Target not found, return appropriate pos
            if aList[pos] > target:
                return pos 
            else:
                return pos + 1
        else:
            if aList[pos] < target:
                return recursiveBinarySearch(aList, pos+1, last, target) # Target is larger of pos
            else:
                return recursiveBinarySearch(aList, first, pos, target) # Target is smaller than pos
    

def testBinarySearch(search):
    testList = [2, 8, 17, 42, 79, 85]

    listSize = len(testList)

    print()
    print('Checking output for values that are present:')
    for i in range(0, listSize):
      target = testList[i]
      foundAt = search(testList, 0, listSize-1, target)
      if foundAt == i:
        print('Found value ', target, ' at index ', foundAt,
              ' as expected')
      else:  
        print('Found value ', target, ' at index ', foundAt,
              ' instead of expected value', i)

    print()
    print('Checking output for values that are not present:')
    for i in range(0, listSize):
      target = testList[i]+1  # no consecutive integers in test list
      foundAt = search(testList, 0, listSize-1, target)
      if foundAt == i+1:
        print('Searching for value ', target, ' returned index ',
              i+1, ' as expected')
      else:  
        print('Searching for value ', target, ' returned index ',
              foundAt, ' instead of expected value', i)
    
    print()
    print('Checking output for value that precedes all present:')
    target = testList[0]-1
    foundAt = search(testList, 0, listSize-1, target)
    if foundAt == 0:
        print('Searching for value ', target, ' returned index ',
              foundAt, ' as expected')
    else:  
        print('Searching for value ', target, ' returned index ',
              foundAt, ' instead of expected value 0')
       
print()
print('Testing recursive binary search')

testBinarySearch(recursiveBinarySearch)

# --------------

def iterativeBinarySearch(aList, first, last, target): 
    found = False
      
    while first <= last and not found: 
        midpoint = (first + last) // 2 
        if aList[midpoint] == target: 
            found = True 
        else: 
            if target < aList[midpoint]: 
                last = midpoint-1 
            else: 
                first = midpoint+1 
       
    if first > last:        # i.e. target not found
        return first
    else:
        return midpoint     # i.e. target found


def binaryInsertionSort(aList):
    '''
    Insertion sort (using binary search)
    '''
    start = time.time()

    for currentPosition in range(1, len(aList)):
        currentValue = aList[currentPosition]
        position = recursiveBinarySearch(aList[0:currentPosition], 0, currentPosition-1, currentValue)
        aList.pop(currentPosition)
        aList.insert(position, currentValue)
        
    elapsed = time.time() - start
    print('binaryInsertionSort: ', len(aList), 'items =', "%.4f" % elapsed,'seconds')

testSortPerformance(binaryInsertionSort, noOfSamples)

