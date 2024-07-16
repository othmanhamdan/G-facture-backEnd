package com.snce.facturation.util;


public class ConvertisseurMontantEnLettres {

    private static final String[] units = { "", "UN", "DEUX", "TROIS", "QUATRE", "CINQ", "SIX", "SEPT", "HUIT", "NEUF" };
    private static final String[] teens = { "DIX", "ONZE", "DOUZE", "TREIZE", "QUATORZE", "QUINZE", "SEIZE", "DIX-SEPT", "DIX-HUIT", "DIX-NEUF" };
    private static final String[] tens = { "", "", "VINGT", "TRENTE", "QUARANTE", "CINQUANTE", "SOIXANTE", "SOIXANTE-DIX", "QUATRE-VINGT", "QUATRE-VINGT-DIX" };

    public static String convertirMontantEnLettres(double montant) {
        // Séparation du montant en parties entière et décimale
        long partieEntiere = (long) montant;
        int partieDecimale = (int) Math.round((montant - partieEntiere) * 100);

        // Conversion de la partie entière en lettres
        String montantEnLettres = convertirPartieEntiereEnLettres(partieEntiere);

        // Ajout du symbole "dirhams"
        montantEnLettres += " DIRHAMS";

        // Conversion de la partie décimale en lettres
        if (partieDecimale > 0) {
            montantEnLettres += " ET " + convertirPartieEntiereEnLettres(partieDecimale) + " CENTIMES";
        }

        return montantEnLettres;
    }

    private static String convertirPartieEntiereEnLettres(long partieEntiere) {
        if (partieEntiere == 0) {
            return "ZERO";
        }
        if (partieEntiere < 0) {
            return "MOINS " + convertirPartieEntiereEnLettres(-partieEntiere);
        }

        String result = "";
        if (partieEntiere >= 1000000) {
            result += convertirPartieEntiereEnLettres(partieEntiere / 1000000) + " MILLION ";
            partieEntiere %= 1000000;
        }
        if (partieEntiere >= 1000) {
            result += convertirPartieEntiereEnLettres(partieEntiere / 1000) + " MILLE ";
            partieEntiere %= 1000;
        }
        if (partieEntiere >= 100) {
            result += convertirPartieEntiereEnLettres(partieEntiere / 100) + " CENT ";
            partieEntiere %= 100;
        }
        if (partieEntiere > 0) {
            if (partieEntiere < 10) {
                result += units[(int) partieEntiere];
            } else if (partieEntiere < 20) {
                result += teens[(int) (partieEntiere - 10)];
            } else {
                result += tens[(int) (partieEntiere / 10)];
                if (partieEntiere % 10 > 0) {
                    result += "-" + units[(int) (partieEntiere % 10)];
                }
            }
        }
        return result;
    }


}
