#Brandon Portillo
#  Comparing interpreted and compiled codes
# 3/5/23
# This Gaussiann elimination is being done with numpy functions.
import random
import numpy as np
import time
def gaus(N):
    A = np.random.rand(N, N + 1)
    for z in range(N):
        for y in range(z + 1, N):
            factor = A[y, z] / A[z, z]
            A[y, z:N + 1] -= factor * A[z, z:N + 1]

    bakcSub = np.zeros(N)
    bakcSub[N - 1] = A[N - 1, N] / A[N - 1, N - 1]
    for i in range(N - 2, -1, -1):
        bakcSub[i] = (A[i, N] - np.dot(A[i, i + 1:N], bakcSub[i + 1:N])) / A[i, i]

    return bakcSub

if __name__ == '__main__':
    # Read the size of matrix from user input
    size = int(input("Enter the size of the matrix : "))
    start = time.time()
    #call function
    gaus(size)
    end = time.time()
    print("Run time  size of :", size, "= ", end - start, " seconds")