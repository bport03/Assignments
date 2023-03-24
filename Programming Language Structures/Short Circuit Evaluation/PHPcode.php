<?php
//Brandon Portillo
// 2-15-2023
// PHP
// Short Circuit

// function calling 
// function to check if circuit 


function f(){
    echo "I have been evaluated";
    return 1;
}
// variable i 



    $i = 1;
// short circuit if if both true call f 
    if( $i == 0 && f()){
        echo"true";
    }else{
        echo"false";
    }


?>