package org.example.demo_builder;

public class Voiture {

    private String marque;
    private String model;
    private int annee;
    private double prix;

    // Role du builder pouvoir construire différents objets voitures sans avoir n constructeur mais un seul constructeur classe en privée pour etre sur de passer par le Builder
    private Voiture (Builder builder) {
        this.marque = builder.marque;
        this.model = builder.model;
        this.annee = builder.annee;
        this.prix = builder.prix;
    }
    public static class Builder {
        private String marque;
        private String model;
        private int annee;
        private double prix;


        public Builder marque (String marque) {
            this.marque = marque;
            return this;
        }
        public Builder model (String model) {
            this.model = model;
            return this;
        }
        public Builder annee (int annee) {
            this.annee = annee;
            return this;
        }
        public Builder prix (double prix) {
            this.prix = prix;
            return this;
        }

        public Voiture build() {
            return new Voiture(this);
        }
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", model='" + model + '\'' +
                ", annee=" + annee +
                ", prix=" + prix +
                '}';
    }
}
