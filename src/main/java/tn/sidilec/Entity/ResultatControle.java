package tn.sidilec.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResultatControle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String valeurMesuree; // Null si contrôle visuel
    private String visuel; // Null si c'est une mesure

    @ManyToOne
    @JoinColumn(name = "plan_controle_id", nullable = false)
    private PlanDeControle planDeControle; // Référence au plan de contrôle

    @ManyToOne
    @JoinColumn(name = "controle_id", nullable = false)
    private Controle controle; // Contrôle auquel appartient ce résultat
}