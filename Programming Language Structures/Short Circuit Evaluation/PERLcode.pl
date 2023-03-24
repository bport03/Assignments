#Brandon Portillo
# 2-15-2023
# PERL 
# Short Circuit

# function calling 
# function to check if circuit 
sub f(){
  print "I have been evaluated";
  return 1;
}

# variable i 
$i = 1;
# short circuit if if both true call f 
if($i == 0 && f()){
  print "True";
}else{
  print "False";
}