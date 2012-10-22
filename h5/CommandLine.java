<<<<<<< HEAD
=======
/*	Технологично училище "Електронни системи"
	http://www.elsys-bg.org/
	11Б клас
	№ 6
	Божидар Ивов Гьорев
_____________________________________________

Да се създаде програма, която да изкарва на екрана стойността на системните свойства по
зададени от командния ред имена на свойствата. Програмата трябва да приема и
невалидни имена. Ако последния подаден аргумент от командния ред е up то стойностите
показани в изхода трябва да са сортиран във възходящ ред. Ако последната стойност е
down изходът трябва да е сортиран в низходящ ред. Стойността по подразбиране, ако не е
посочено up или down, е up.

Пример:
java HomeWork1 java.version java.vm.version java.vendor invalid java.vendor.url down 
трябва до доведе до
http://java.sun.com/
Sun Microsystems Inc.
11.0-b15
1.6.0_10

*/

>>>>>>> e65da185ca27d2d1c021b477413945dd648653d0
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class CommandLine {
	public static void main(String [] args) {
		if(args[args.length-1].equals("down")) {
			Arrays.sort(args,Collections.reverseOrder());
			for(String str:args) {
<<<<<<< HEAD
				if(System.getProperty(str) != null){ System.out.println(
					System.getProperty(str));
=======
				if(System.getProperty(str) != null){ 
					System.out.println(System.getProperty(str));
>>>>>>> e65da185ca27d2d1c021b477413945dd648653d0
				}
			}
		} else {
			Arrays.sort(args);
			for(String str:args) {
				if(System.getProperty(str) != null){ 
					System.out.println(System.getProperty(str));
				}
			}
		}
	}
}
