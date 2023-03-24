#Brandon Portillo
#2/15/2023
# Short Circuit Evaluation
 
 
 #function 
 f(){
    echo "I have been evaluated"
    return 1
}  

main(){
 i=1

 if [ $i -eq 0 ] && [f]; 
    then
          echo "true"
    else 
        echo "false"
    fi
}
main