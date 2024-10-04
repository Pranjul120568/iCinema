def greatest_pseudorandom_number(matrix, n, m, k):
    # Initialize the DP array with -1 (indicating impossible state)
    dp = [[-1] * m for _ in range(n)]
    
    # Initialize the first row based on the unit type
    for j in range(m):
        if matrix[0][j] != 2:
            dp[0][j] = 0 if matrix[0][j] == 0 else 1

    # Process each row in the matrix
    for i in range(1, n):
        for j in range(m):
            if matrix[i][j] == 2:
                continue  # Skip cells with unit type 2
            
            max_val = -1
            # Check cells from the previous row that can transition to (i, j)
            for dj in [-1, 0, 1]:
                prev_col = j + dj
                if 0 <= prev_col < m and dp[i-1][prev_col] != -1:
                    max_val = max(max_val, dp[i-1][prev_col])
            
            if max_val != -1:
                dp[i][j] = max_val + (1 if matrix[i][j] == 1 else 0)
    
    # Get the maximum value without using the device
    max_without_device = max(dp[n-1]) if any(dp[n-1][j] != -1 for j in range(m)) else -1
    
    # Try using the device on every possible k consecutive rows
    max_with_device = max_without_device
    for start_row in range(n - k + 1):
        # Make a copy of the dp array
        dp_copy = [row[:] for row in dp]
        
        # Apply the device to k consecutive rows starting from start_row
        for i in range(start_row, start_row + k):
            for j in range(m):
                if matrix[i][j] == 2:
                    dp_copy[i][j] = -1  # Reset cell to impossible state
                elif matrix[i][j] == 1:
                    dp_copy[i][j] = max(dp_copy[i][j], dp[i][j] + 1)  # Update value
        
        # Recompute dp values from start_row + k to the end
        for i in range(start_row + k, n):
            for j in range(m):
                if matrix[i][j] == 2:
                    dp_copy[i][j] = -1
                else:
                    max_val = -1
                    for dj in [-1, 0, 1]:
                        prev_col = j + dj
                        if 0 <= prev_col < m and dp_copy[i-1][prev_col] != -1:
                            max_val = max(max_val, dp_copy[i-1][prev_col])
                    if max_val != -1:
                        dp_copy[i][j] = max_val + (1 if matrix[i][j] == 1 else 0)
        
        # Update the maximum value considering the device usage
        if any(dp_copy[n-1][j] != -1 for j in range(m)):
            max_with_device = max(max_with_device, max(dp_copy[n-1]))
    
    return max_with_device

# Example usage:
matrix = [[1, 2, 2, 2], [0, 0, 0, 1], [0, 0, 0, 1]]
n = 3
m = 4
k = 1
print(greatest_pseudorandom_number(matrix, n, m, k))  # Output should be 2
