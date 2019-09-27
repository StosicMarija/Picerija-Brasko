package sedmidomaci;

import java.util.Scanner;

public class Pizza {

	static void ispisidane() {
		System.out.println("Koji je danas dan (Pon/Uto/Sre/Cet/Pet/Sub/Ned):");
	}

	public static void main(String[] args) {
		Scanner ulaz = new Scanner(System.in);
		String dan;
		do {
			ispisidane();
			dan = ulaz.next();
		} while (!dan.equals("Pon") && !dan.equals("Uto") && !dan.equals("Sre") && !dan.equals("Cet")
				&& !dan.equals("Pet") && !dan.equals("Sub") && !dan.equals("Ned"));
		switch (dan) {
		case "Pon":
			porudzbina(dan);
			break;

		case "Uto":
			porudzbina(dan);
			break;

		case "Sre":
			porudzbina(dan);
			break;

		case "Cet":
			porudzbina(dan);
			break;

		case "Pet":
			porudzbina(dan);
			break;

		case "Sub":
			porudzbina(dan);
			break;

		case "Ned":
			porudzbina(dan);
			break;

		default:
			System.out.println("Greska u unosu! Pokusajte ponovo!");
			dan = ulaz.next();
			break;
		}
	}

	static void porudzbina(String dan) {
		Scanner ulaz = new Scanner(System.in);
		int j = 1;
		int musterija = 1;
		int brojpica = 0;
		String ispis = "";
		String dnevnipopust = "";
		int popust = 0;
		do {
			System.out.println("\nMusterija id#" + musterija);
			brojpica = ulaz.nextInt();
			int racun = 0, ukupnipopust = 0;
			if (brojpica != -1) {
				ispis += "- Racun za musteriju id#" + musterija + " -";
				for (int i = 1; i <= brojpica; i++) {
					System.out.print(" ");
					int pica = ulaz.nextInt();
					popust = 0;

					switch (pica) {
					case 2:
						if (j % 7 == 0) {
							ispis += "\n AKCIJA #7 Cappriciosa 0";
							racun += 0;
						} else {
							if (i % 4 == 0) {
								ispis += "\nAKCIJA 3+1 Cappriciosa 0";
								racun += 0;
							} else {
								ispis += "\nPizza Cappriciosa 320";
								racun += 320;
								popust = dnevnipopust(dan, pica);
							}
							ukupnipopust += popust;
							if (popust > 0 && dan.equals("Cet")) {
								dnevnipopust += "\n DNEVNA 10% Capricciosa -" + popust;
							} else if (popust > 0 && (dan.equals("Sub") || dan.equals("Ned"))) {
								dnevnipopust += "\n DNEVNA 15% Capricciosa -" + popust;
							}
						}
						break;
					case 3:
						if (j % 7 == 0) {
							ispis += "\n AKCIJA #7 Pepperoni 0";
							racun += 0;
						} else {
							if (i % 4 == 0) {
								ispis += "\nAKCIJA 3+1 Pepperoni 0";
								racun += 0;
							} else {
								ispis += "\nPizza Pepperoni 290";
								racun += 290;
								popust = dnevnipopust(dan, pica);
							}
							ukupnipopust += popust;
							if (popust > 0 && (dan.equals("Sub") || dan.equals("Ned"))) {
								dnevnipopust += "\n DNEVNA 15% Pepperoni -" + popust;
							}
						}
						break;
					case 5:
						if (j % 7 == 0) {
							ispis += "\nAKCIJA #7 Vesuvio 0";
							racun += 0;
						} else {
							if (i % 4 == 0) {
								ispis += "\nAKCIJA 3+1 Vesuvio 0";
								racun += 0;
							} else {
								ispis += "\nPizza Vesuvio 310";
								racun += 310;
								popust = dnevnipopust(dan, pica);
							}
							ukupnipopust += popust;
							if (popust > 0 && dan.equals("Uto")) {
								dnevnipopust += "\n DNEVNA 10% Vesuvio -" + popust;
							} else if (popust > 0 && (dan.equals("Sub") || dan.equals("Ned"))) {
								dnevnipopust += "\n DNEVNA 15% Vesuvio -" + popust;
							}
						}
						break;
					default:
						break;
					}
					j += 1;
				}
				ispis += "\nUkupno: " + racun + "\n";
				ispis += dnevnipopust;
				if (ukupnipopust > 0) {
					ispis += "\n Ukupno: " + (racun - ukupnipopust) + "\n";
				}
				ispis += "-----------------------";
				System.out.print(ispis);
				musterija += 1;
				ispis = "";
				ukupnipopust = 0;
				dnevnipopust = "";
				popust = 0;
			}
		} while (brojpica != -1);
	}

	static int dnevnipopust(String dan, int pica) {
		int popust = 0;
		if (dan.equals("Uto") && pica == 5) {
			popust = (310 * 10) / 100;
		}
		if (dan.equals("Cet") && pica == 2) {
			popust = (320 * 10) / 100;
		}
		if (dan.equals("Sub") || dan.equals("Ned")) {
			if (pica == 2) {
				popust = (320 * 15) / 100;
			} else if (pica == 3) {
				popust = (290 * 15) / 100;
			} else {
				popust = (310 * 15) / 100;
			}
		}
		return popust;
	}
}
