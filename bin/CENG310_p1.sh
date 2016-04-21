col=$(tput cols)
$num=1;
 printf '%*s%s' $col "Feisal Salim n01011822"
users=$(users)
printf '%s\n' $users

cmd=$(who |wc -l)
echo "number of users"
expr $cmd $num
ls -l
ls -l |wc -l 

echo "number of directories :" 
cmd2=$(ls -d |wc -l)
expr $cmd2 - $num
