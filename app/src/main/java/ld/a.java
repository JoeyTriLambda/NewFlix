package ld;

import flix.com.vision.R;
import flix.com.vision.models.Movie;
import java.util.Random;
import org.threeten.bp.chrono.HijrahDate;

/* compiled from: Network.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f16047a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16048b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16049c;

    /* renamed from: d, reason: collision with root package name */
    public Movie f16050d;

    public a(int i10, String str, String str2, int i11) {
        this.f16048b = i10;
        this.f16047a = str;
        this.f16049c = i11;
        switch (i10) {
            case 2:
                Movie movie = new Movie();
                this.f16050d = movie;
                movie.I = "2005";
                movie.setTitle("Grey's Anatomy");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama");
                Movie movie2 = this.f16050d;
                movie2.f12395m = R.drawable.abc_movie;
                movie2.setOverview("Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.");
                break;
            case 16:
                Movie movie3 = new Movie();
                this.f16050d = movie3;
                movie3.I = "2005";
                movie3.setTitle("How I Met Your Mother");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Comedy");
                Movie movie4 = this.f16050d;
                movie4.f12395m = R.drawable.cbs_movie;
                movie4.setOverview("A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother");
                break;
            case 49:
                Movie movie5 = new Movie();
                this.f16050d = movie5;
                movie5.I = "2011";
                movie5.setTitle("Game of Thrones");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Sci-Fi & Fantasy, Drama, Action & Adventure");
                Movie movie6 = this.f16050d;
                movie6.f12395m = R.drawable.hbo_movie;
                movie6.setOverview("Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.");
                break;
            case 174:
                Movie movie7 = new Movie();
                this.f16050d = movie7;
                movie7.I = "2008";
                movie7.setTitle("Breaking Bad");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama, Crime");
                Movie movie8 = this.f16050d;
                movie8.f12395m = R.drawable.amc_movie;
                movie8.setOverview("When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.");
                break;
            case 213:
                this.f16050d = new Movie();
                int iNextInt = new Random().nextInt(4) + 1;
                if (iNextInt != 1) {
                    if (iNextInt != 2) {
                        if (iNextInt != 3) {
                            Movie movie9 = this.f16050d;
                            movie9.I = "2021";
                            movie9.setTitle("Squid Game");
                            this.f16050d.setType(1);
                            this.f16050d.setGenres("Action & Adventure, Mystery, Drama");
                            Movie movie10 = this.f16050d;
                            movie10.f12395m = R.drawable.squid;
                            movie10.setOverview("Hundreds of cash-strapped players accept a strange invitation to compete in children's games. Inside, a tempting prize awaits — with deadly high stakes.");
                            break;
                        } else {
                            Movie movie11 = this.f16050d;
                            movie11.I = "2022";
                            movie11.setTitle("Wednesday");
                            this.f16050d.setType(1);
                            this.f16050d.setGenres("Sci-Fi & Fantasy, Mystery, Comedy");
                            Movie movie12 = this.f16050d;
                            movie12.f12395m = R.drawable.netflix_movie3;
                            movie12.setOverview("Wednesday Addams is sent to Nevermore Academy, a bizarre boarding school where she attempts to master her psychic powers, stop a monstrous killing spree of the town citizens, and solve the supernatural mystery that affected her family 25 years ago — all while navigating her new relationships.");
                            break;
                        }
                    } else {
                        Movie movie13 = this.f16050d;
                        movie13.I = "2018";
                        movie13.setTitle("House of Cards");
                        this.f16050d.setType(1);
                        this.f16050d.setGenres("Drama");
                        Movie movie14 = this.f16050d;
                        movie14.f12395m = R.drawable.netflix_movie2;
                        movie14.setOverview("Set in present day Washington, D.C., House of Cards is the story of Frank Underwood, a ruthless and cunning politician, and his wife Claire who will stop at nothing to conquer everything. This wicked political drama penetrates the shadowy world of greed, sex and corruption in modern D.C.");
                        break;
                    }
                } else {
                    Movie movie15 = this.f16050d;
                    movie15.I = "2011";
                    movie15.setTitle("Black Mirror");
                    this.f16050d.setType(1);
                    this.f16050d.setGenres("Sci-Fi & Fantasy, Drama, Mystery");
                    Movie movie16 = this.f16050d;
                    movie16.f12395m = R.drawable.netflix_movie;
                    movie16.setOverview("Over the last ten years, technology has transformed almost every aspect of our lives before we've had time to stop and question it. In every home; on every desk; in every palm - a plasma screen; a monitor; a smartphone - a black mirror of our 21st Century existence.");
                    break;
                }
            case 318:
                Movie movie17 = new Movie();
                this.f16050d = movie17;
                movie17.I = "2014";
                movie17.setTitle("Power");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Crime, Drama");
                Movie movie18 = this.f16050d;
                movie18.f12395m = R.drawable.starz_movie;
                movie18.setOverview("A successful New York entrepreneur lives a double life as the head of a drug empire that serves only the rich and influential, all while wanting to escape the underworld and keep his family safe.");
                break;
            case 453:
                Movie movie19 = new Movie();
                this.f16050d = movie19;
                movie19.I = "2021";
                movie19.setTitle("Only Murders in the Building");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Comedy, Mystery, Crime");
                Movie movie20 = this.f16050d;
                movie20.f12395m = R.drawable.hulu_movie;
                movie20.setOverview("Three strangers share an obsession with true crime and suddenly find themselves wrapped up in one.");
                break;
            case 999:
                Movie movie21 = new Movie();
                this.f16050d = movie21;
                movie21.I = "2023";
                movie21.setTitle("Animal");
                this.f16050d.setType(0);
                this.f16050d.setGenres("Action, Crime, Drama");
                Movie movie22 = this.f16050d;
                movie22.f12395m = R.drawable.bollywood_movie;
                movie22.setOverview("A son undergoes a remarkable transformation as the bond with his father begins to fracture, and he becomes consumed by a quest for vengeance.");
                break;
            case 1024:
                Movie movie23 = new Movie();
                this.f16050d = movie23;
                movie23.I = "2019";
                movie23.setTitle("The Boys");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Sci-Fi & Fantasy, Action & Adventure");
                Movie movie24 = this.f16050d;
                movie24.f12395m = R.drawable.prime_movie;
                movie24.setOverview("A group of vigilantes known informally as “The Boys” set out to take down corrupt superheroes with no more than blue-collar grit and a willingness to fight dirty.");
                break;
            case 2552:
                Movie movie25 = new Movie();
                this.f16050d = movie25;
                movie25.I = "2019";
                movie25.setTitle("For All Mankind");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama, Sci-Fi & Fantasy, War & Politics");
                Movie movie26 = this.f16050d;
                movie26.f12395m = R.drawable.apple_movie;
                movie26.setOverview("Explore an aspirational world where NASA and the space program remained a priority and a focal point of our hopes and dreams as told through the lives of NASA astronauts, engineers, and their families.");
                break;
            case 2739:
                Movie movie27 = new Movie();
                this.f16050d = movie27;
                movie27.I = "2019";
                movie27.setTitle("The Mandalorian");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Sci-Fi & Fantasy, Action & Adventure, Drama");
                Movie movie28 = this.f16050d;
                movie28.f12395m = R.drawable.disney_movie;
                movie28.setOverview("The journeys of the Mandalorian through the Star Wars galaxy continue. Once a lone bounty hunter, Din Djarin has reunited with Grogu. Meanwhile, the New Republic struggles to lead the galaxy away from its dark history. The Mandalorian will cross paths with old allies and make new enemies as he and Grogu continue their journey together");
                break;
            case 3343:
                Movie movie29 = new Movie();
                this.f16050d = movie29;
                movie29.I = "2020";
                movie29.setTitle("Tyler Perry's Ruthless");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama");
                Movie movie30 = this.f16050d;
                movie30.f12395m = R.drawable.bet_plus_poster;
                movie30.setOverview("A spinoff of \"The Oval,\" follows Ruth Truesdale as she's forced to play nice with a scandalous religious cult of powerful sex crazed fanatics in the hopes of freeing herself and her daughter.");
                break;
            case 3353:
                Movie movie31 = new Movie();
                this.f16050d = movie31;
                movie31.I = "2024";
                movie31.setTitle("Fight Night: The Million Dollar Heist");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama, Crime");
                Movie movie32 = this.f16050d;
                movie32.f12395m = R.drawable.peacock_poster1;
                movie32.setOverview("The story of how on the night of Ali’s defeat of Jerry Quarry, which came after he was banned from boxing for refusing to enter the military draft, hundreds of guests at an after-party were robbed at gunpoint, becoming one of the largest armed robberies the country has ever seen.");
                break;
            case 4025:
                Movie movie33 = new Movie();
                this.f16050d = movie33;
                movie33.I = "2010";
                movie33.setTitle("Luther");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Crime, Drama, Mystery");
                Movie movie34 = this.f16050d;
                movie34.f12395m = R.drawable.brit_box_poster;
                movie34.setOverview("A dark psychological crime drama starring Idris Elba as Luther, a man struggling with his own terrible demons, who might be as dangerous as the depraved murderers he hunts");
                break;
            case 4330:
                Movie movie35 = new Movie();
                this.f16050d = movie35;
                movie35.I = "2023";
                movie35.setTitle("Special Ops: Lioness");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Drama");
                Movie movie36 = this.f16050d;
                movie36.f12395m = R.drawable.paramount_movie;
                movie36.setOverview("Cruz Manuelos, a rough-around-the-edges but passionate young Marine, is recruited to join the CIA’s Lioness Engagement Team to help bring down a terrorist organization from within. Joe, the station chief of the Lioness program, is tasked with training, managing and leading her female undercover operatives.");
                break;
            case 9991:
                Movie movie37 = new Movie();
                this.f16050d = movie37;
                movie37.I = "2024";
                movie37.setTitle("Parasyte: The Grey");
                this.f16050d.setType(1);
                this.f16050d.setGenres("Sci-Fi & Fantasy,Drama,Action & Adventure");
                Movie movie38 = this.f16050d;
                movie38.f12395m = R.drawable.drama_movie;
                movie38.setOverview("When unidentified parasites violently take over human hosts and gain power, humanity must rise to combat the growing threat.");
                break;
            case HijrahDate.MAX_VALUE_OF_ERA /* 9999 */:
                Movie movie39 = new Movie();
                this.f16050d = movie39;
                movie39.I = "2019";
                movie39.setTitle("Avengers: Endgame");
                this.f16050d.setType(0);
                this.f16050d.setGenres("Adventure, Science Fiction, Action");
                Movie movie40 = this.f16050d;
                movie40.f12395m = R.drawable.marvel_movie;
                movie40.setOverview("After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.");
                break;
        }
    }

    public static int getProviderId(int i10) {
        switch (i10) {
            case 213:
                return 8;
            case 318:
                return 43;
            case 453:
                return 15;
            case 922:
            case 3353:
                return 386;
            case 928:
                return 12;
            case 1024:
                return 9;
            case 2552:
                return 350;
            case 2739:
                return 337;
            case 3186:
                return 384;
            case 3343:
                return 1759;
            case 5506:
                return 531;
            default:
                return 0;
        }
    }

    public a() {
    }
}
