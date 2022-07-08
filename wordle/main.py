import glob
import os
#this does not work
def words():
    list = []
    word = ""
    with open('C:/Users/etomo/OneDrive/Desktop/wordle/words.txt', 'r') as f:
        lines = f.read()
        for num in range(len(lines)):
            if (lines[num] == '\n'):
                #print (lines[num-1])
                num2 = 0
                while (num2 != num+1):
                    word=word+lines[num2]
                    num2+=1

                list.append(word)   
                num = 0
        print (lines)

words()
