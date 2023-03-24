use strict;
use warnings;

open(my $input, "<", "control-char.txt") or die "Cannot open input file: $!";
open(my $output, ">", "output.txt") or die "Cannot open output file: $!";

my $inc = 0;
my $outc = 0;

while (my $line = <$input>) {
    chomp($line);
    my $length = length($line);
    
    for (my $i = 0; $i < $length; $i++) {
        if (ord(substr($line, $i, 1)) == 3 && !$inc) {
            $inc = 1;
            $outc = 0;
        }
        if (ord(substr($line, $i, 1)) == 2 && $inc) {
            $inc = 0;
            $outc = 1;
        }
        if (!$inc && !$outc) {
            if ($i == $length-1) {
                # remove non date need it that are not space at the end of the line
               my $out12= substr ($line,-1);
            
                if (substr ($line, -1) ne 32) {
                    print $output "";
                }
            } else {
                print $output substr($line, $i, 1);
            }
        }
        if ($outc) {
            $outc = 0;
        }
    }
    if (!$inc) {
        print $output "\n";
    }
}

close($input);
close($output);
