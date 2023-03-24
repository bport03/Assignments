import sys
def main():
    #Open and create a new file ouput
    with open("control-char.txt", "r") as input_file, open("outcome.txt", "w") as output_file:
        inc = False
        outc = False
        #loop througout the file and check for control c and control b
        for line in input_file:
            length = len(line)

            for i in range(length):
                if ord(line[i]) == 3 and inc==False:
                    inc = True
                    outc = False
                if ord(line[i]) == 2 and inc == True:
                    inc = False
                    outc = True
                if not inc and not outc:

                        output_file.write(line[i])
                if outc:
                    outc = False
        input_file.close()
        output_file.close()

if __name__=="__main__":
    main()