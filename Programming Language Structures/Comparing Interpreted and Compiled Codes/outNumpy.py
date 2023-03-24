#Brandon Portillo
#  Comparing interpreted and compiled codes
# 3/5/23
# This Gaussiann elimination is being done without numpy functions.
import random
import time
# to do gaussian elimination
def gaus(N):
  for z in range(N-1):
    for i in range(z+1,N):
      pivot = matrix[z][z]
      factor = matrix[i][z]/pivot
      matrix[i][z] = factor
      for j in range(z+1,N+1):
        matrix[i][j] = matrix[i][j] - factor*matrix[z][j]

  # Back substitution
  backSub = [0.0]*N
  backSub[N-1] = matrix[N-1][N]/matrix[N-1][N-1]
  for i in range(N-2,-1,-1):
    temp = [matrix[i][j]*backSub[j] for j in range(i+1,N)]
    backSub[i] = (matrix[i][N]-sum(temp))/matrix[i][i]

  return backSub
if __name__ == '__main__':
  size = int(input("Enter the size of the matrix : "))
  # mtrix with random number
  matrix = [[random.uniform(0,200) for j in range(size+1)] for i in range(size)]
  start = time.time()
  # call function
  gaus(size)
  end = time.time()
  print("Run time  size of :", size ,"= ", end - start, " seconds")