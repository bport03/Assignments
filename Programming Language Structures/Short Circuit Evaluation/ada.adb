-- Brandon Portillo
-- 2/15/2023
-- PA 2: Short Circuit Evaluation

with Ada.Text_IO; use Ada.Text_IO;


procedure main is
    i : Integer; 
    -- declare of variables to be use 
    
    --function of f use for calling later on in code
    function f return Boolean is 
    begin
      -- print out string
        Put_line("I have been evaluated");
        return true;
    end f;
    -- end of function f 
    
    -- start of main procedure
    begin
      -- set variables 
        i:=1;
        -- check short circuit if statment 
        if i = 0 and f then
            Put_line("True");
        else
            Put_line("False");
        end if;
        
end main; 
          