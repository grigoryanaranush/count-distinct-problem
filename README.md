This Application is for counting number of unique address in the file using as less memory and time as possible.
For this reason I have used HyperLogLog(HLL) algorythm. 
This is a great solution if we are fine with an estimation within a few percent and don't need the exact number of unique visits,
then we can use the HLL.
