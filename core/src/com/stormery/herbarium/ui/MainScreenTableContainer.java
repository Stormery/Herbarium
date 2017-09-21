package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.herbs.Althea;
import com.stormery.herbarium.herbs.Chamomile;
import com.stormery.herbarium.herbs.Knotgrass;
import com.stormery.herbarium.herbs.Sage;
import com.stormery.herbarium.herbs.Tilia;
import com.stormery.herbarium.herbs.ViolaTricolor;
import com.stormery.herbarium.herbs.Willow;
import com.stormery.herbarium.herbs.Yarrow;
import com.stormery.herbarium.service.EnumLanguage;
import com.stormery.herbarium.service.EnumTherapeuticProperties;

/**
 * Created by Ayo on 2017-08-16.
 */

public class MainScreenTableContainer {
    /////Tables
    private Table tableMain;
    private Table tableBookmarkScrollable;
    private Table tableRight;
    public static Table tableInnerScrollable;
    private boolean tableDebug = true;

    private Stage stage;

    ButtonGroup buttonGroup;
//Therapeutic Use buttons
    private UseButton bttAntibacterial;
    private UseButton bttAntipyretic;
    private UseButton bttAntispasmodic;
    private UseButton bttAntitussive;
    private UseButton bttAstrigents;
    private UseButton bttCardiacInsufficiency;
    private UseButton bttCarminative;
    private UseButton bttCholagogues;
    private UseButton bttDiaphoretic;
    private UseButton bttDemulcent;
    private UseButton bttDiuretic;
    private UseButton bttExpectorant;
    private UseButton bttImprovingDigestion;
    private UseButton bttLaxative;
    private UseButton bttProtectiveScreening;
    private UseButton bttSedative;
    private UseButton bttSpasmolytic;
    private UseButton bttUrinaryTractDisinfectant;
    ///
    private static boolean signForPrzeciwbakteryjne;
    private static boolean signForPrzeciwkaszlowe;
    private static boolean signForPrzeciwgoraczkowe;
    private static boolean signForOdkazajaceDrogiMoczowe;
    private static boolean signForPrzeciwskurczowe;
    private static boolean signForSciagajace;
    private static boolean signForNiewydolnoscKrazenia;
    private static boolean signForWiatropedne;
    private static boolean signForZolciopedne;
    private static boolean signForPrzeciwzapalne;
    private static boolean signForNapotne;
    private static boolean signForMoczopedne;
    private static boolean signForWykrztusne;
    private static boolean signForPobudzanieTrawienia;
    private static boolean signForPrzeczyszczajace;
    private static boolean signForOslaniajace;
    private static boolean signForUspokajajace;
    private static boolean signForRozkurczajace;


    public MainScreenTableContainer(EnumLanguage language, Stage stage) {
        this.stage = stage;
        initTable(language);
    }

    private void initTable(EnumLanguage language) {
        //TODO zmienic skin i Atlas
        Image tableLogo = new Image(new Texture("backgroundImg/Logo.png"));

//InstantiateTables
        tableMain = new Table();
        tableRight = new Table();
        tableMain.setFillParent(true);
//Debug
        tableMain.setDebug(tableDebug);
        tableRight.setDebug(tableDebug);
        //tableUsageType.setDebug(tableDebug);
//Set MainTable position
        tableMain.top().left().padRight(25f).padTop(10f);
/*
LEFT
        Bookmark scrollable
*/
        tableBookmarkScrollable();
        /* Instantiate Box with Therapeutic use Buttons */
        LanguageChangeTableOfTherapeuticUse(language);
/*
RIGHT
        TODO wyszukiwarki nie ma
        tableRight.add().height(152f).top(); //LOGO
        tableRight.row();
        Instantiate Box with ScrollableButtons
        */
        tableInnerWithScrollableHerbs();
        stage.addActor(tableMain);
    }

    private void LanguageChangeTableOfTherapeuticUse(EnumLanguage language) {
        if(language.equals(EnumLanguage.POLISH)){
            tableWithTherapeuticUseTypesPolish();
        }else if(language.equals(EnumLanguage.ENGLISH)){
            tableWithTherapeuticUseTypesEnglish();
        }
    }



    private void tableBookmarkScrollable() {

        tableBookmarkScrollable = new Table();
        tableBookmarkScrollable.setDebug(tableDebug);
        ScrollPane scrollPane = new ScrollPane(tableBookmarkScrollable);
        scrollPane.setOverscroll(false, false);

        tableMain.add(scrollPane).top().left().width(120f).height(535f)
                .padLeft(20f).padRight(20f).padBottom(5f).padTop(115f);//bookmark
    }

    private void tableInnerWithScrollableHerbs() {
        tableInnerScrollable = new Table();
        tableInnerScrollable.setDebug(tableDebug);

        ScrollPane scrollPane = new ScrollPane(tableInnerScrollable);
        scrollPane.setOverscroll(false, false);

        //tableMain.row();
        tableRight.add(scrollPane).colspan(2).top();
        tableMain.add(tableRight).top().left();
    }
    private void tableWithTherapeuticUseTypesEnglish() {
        float therapeuticUsePadTop = 20f;
        float therapeuticWidth = 110;
        float therapeuticHeight = 50f;
        /*
        If i click on TherapeuticUseButton
         table inner with herbs is cleared
         */
        // Init Buttons
     initTherapeuticButtonsENG();

        tableBookmarkScrollable.add(bttAntibacterial).top().left().padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttAntipyretic).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttAntispasmodic).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttAntitussive).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttAstrigents).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttCardiacInsufficiency).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttCarminative).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttCholagogues).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttDemulcent).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttDiaphoretic).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttDiuretic).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttExpectorant).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttImprovingDigestion).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttLaxative).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttProtectiveScreening).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttSedative).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttSpasmolytic).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(bttUrinaryTractDisinfectant).padTop(therapeuticUsePadTop).height(therapeuticHeight).width(therapeuticWidth);
        tableBookmarkScrollable.row();
    }// EnglishProperties table

    private void initTherapeuticButtonsENG() {
        bttAntibacterial = new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwbakt click");
                tableInnerScrollable.clearChildren();
                if(!signForPrzeciwbakteryjne){
                    Aloe.initAloe();
                }
                signForPrzeciwbakteryjne= !signForPrzeciwbakteryjne;
            }
        });

        bttAntipyretic = new UseButton(EnumTherapeuticProperties.ANTIPYRETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("przeciwgoraczkowe click");
                tableInnerScrollable.clearChildren();
                if(!signForPrzeciwgoraczkowe){
                    Tilia.initTilia();
                    Willow.initWillow();
                }
                signForPrzeciwgoraczkowe= !signForPrzeciwgoraczkowe;
            }
        });

        bttAntispasmodic = new UseButton(EnumTherapeuticProperties.ANTISPASMODIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwskurczowe  click");
                tableInnerScrollable.clearChildren();
                if(!signForPrzeciwskurczowe){
                    Chamomile.initChamomile();
                    Yarrow.initYarrow();
                }
                signForPrzeciwskurczowe= !signForPrzeciwskurczowe;
            }
        });

        bttAntitussive = new UseButton(EnumTherapeuticProperties.ANTITUSSIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwkaszlowe  click");
                tableInnerScrollable.clearChildren();
                if(!signForPrzeciwkaszlowe){
                    Althea.initAlthea();
                }
                signForPrzeciwkaszlowe= !signForPrzeciwkaszlowe;
            }
        });

        bttAstrigents = new UseButton(EnumTherapeuticProperties.ASTRINGENTS, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Sciagajace  click");
                tableInnerScrollable.clearChildren();
                if(!signForSciagajace){
                    Chamomile.initChamomile();
                    Knotgrass.initKnotgrass();
                    Sage.initSage();
                    ViolaTricolor.initViolaTricolor();
                    Willow.initWillow();
                }
                signForSciagajace= !signForSciagajace;
            }
        });

        bttCardiacInsufficiency = new UseButton(EnumTherapeuticProperties.CARDIAC_INSUFFICIENCY, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("NiewydolnoscKrazenia  click");
                tableInnerScrollable.clearChildren();
                signForNiewydolnoscKrazenia= !signForNiewydolnoscKrazenia;
            }
        });

        bttCarminative = new UseButton(EnumTherapeuticProperties.CARMINATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wiatropedne  click");
                tableInnerScrollable.clearChildren();
                signForWiatropedne= !signForWiatropedne;
            }
        });

        bttCholagogues = new UseButton(EnumTherapeuticProperties.CHOLAGOGUES, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Zolciopedne  click");
                tableInnerScrollable.clearChildren();
                signForZolciopedne= !signForZolciopedne;
            }
        });

        bttDemulcent = new UseButton(EnumTherapeuticProperties.DEMULCENT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwzapalne  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwzapalne= !signForPrzeciwzapalne;
            }
        });

        bttDiaphoretic = new UseButton(EnumTherapeuticProperties.DIAPHORETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Napotne  click");
                tableInnerScrollable.clearChildren();
                signForNapotne= !signForNapotne;
            }
        });

        bttDiuretic = new UseButton(EnumTherapeuticProperties.DIURETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Moczopednt click");
                tableInnerScrollable.clearChildren();
                signForMoczopedne= !signForMoczopedne;
            }
        });

        bttExpectorant = new UseButton(EnumTherapeuticProperties.EXPECTORANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wykrztusne  click");
                tableInnerScrollable.clearChildren();
                signForWykrztusne= !signForWykrztusne;
            }
        });

        bttImprovingDigestion = new UseButton(EnumTherapeuticProperties.IMPROVING_DIGESTION, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Pobudzatrawienie  click");
                tableInnerScrollable.clearChildren();
                tableInnerScrollable.clearChildren();
                signForPobudzanieTrawienia= !signForPobudzanieTrawienia;
            }
        });

        bttLaxative = new UseButton(EnumTherapeuticProperties.LAXATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeczyszczajace  click");
                tableInnerScrollable.clearChildren();
                signForPrzeczyszczajace= !signForPrzeczyszczajace;
            }
        });

        bttProtectiveScreening = new UseButton(EnumTherapeuticProperties.PROTECTIVE_SCREENING, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Oslaniajace  click");
                tableInnerScrollable.clearChildren();
                signForOslaniajace= !signForOslaniajace;
            }
        });

        bttSedative = new UseButton(EnumTherapeuticProperties.SEDATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Uspokajajace  click");
                tableInnerScrollable.clearChildren();
                signForUspokajajace= !signForUspokajajace;
            }
        });

        bttSpasmolytic = new UseButton(EnumTherapeuticProperties.SPASMOLYTIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Rozkurczajace  click");
                tableInnerScrollable.clearChildren();
                signForRozkurczajace= !signForRozkurczajace;
            }
        });

        bttUrinaryTractDisinfectant = new UseButton(EnumTherapeuticProperties.URINARY_TRACT_DISINFECTANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Odkazajace drogi moczowe  click");
                tableInnerScrollable.clearChildren();
                signForOdkazajaceDrogiMoczowe= !signForOdkazajaceDrogiMoczowe;
            }
        });


        buttonGroup = new ButtonGroup(bttAntibacterial,bttAntipyretic,bttAntispasmodic,bttAntitussive,bttAstrigents,
                                        bttCardiacInsufficiency,bttCarminative,bttCholagogues,bttDiaphoretic,bttDemulcent,
                                        bttDiuretic, bttExpectorant, bttImprovingDigestion, bttLaxative, bttProtectiveScreening,
                                        bttSedative,bttSpasmolytic,bttUrinaryTractDisinfectant);
        buttonGroup.setMaxCheckCount(1);
        buttonGroup.setMinCheckCount(0);
//i
        buttonGroup.setUncheckLast(true); //If true,
    }//initbuttonsENG


    // TODO Zmienic kolejnosc dla polskiej wersji
    private void tableWithTherapeuticUseTypesPolish() {
        float therapeuticUsePadTop = 20f;
        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwbakt click");
                tableInnerScrollable.clearChildren();
                    signForPrzeciwbakteryjne= !signForPrzeciwbakteryjne;
            }
        })).top().left().padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIPYRETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("przeciwgoraczkowe click");
                tableInnerScrollable.clearChildren();
                    signForPrzeciwgoraczkowe= !signForPrzeciwgoraczkowe;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTISPASMODIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwskurczowe  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwskurczowe= !signForPrzeciwskurczowe;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTITUSSIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwkaszlowe  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwkaszlowe= !signForPrzeciwkaszlowe;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ASTRINGENTS, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Sciagajace  click");
                tableInnerScrollable.clearChildren();
                signForSciagajace= !signForSciagajace;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CARDIAC_INSUFFICIENCY, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("NiewydolnoscKrazenia  click");
                tableInnerScrollable.clearChildren();
                signForNiewydolnoscKrazenia= !signForNiewydolnoscKrazenia;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CARMINATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wiatropedne  click");
                tableInnerScrollable.clearChildren();
                signForWiatropedne= !signForWiatropedne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CHOLAGOGUES, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Zolciopedne  click");
                tableInnerScrollable.clearChildren();
                signForZolciopedne= !signForZolciopedne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DEMULCENT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwzapalne  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwzapalne= !signForPrzeciwzapalne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DIAPHORETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Napotne  click");
                tableInnerScrollable.clearChildren();
                signForNapotne= !signForNapotne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DIURETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Moczopednt click");
                tableInnerScrollable.clearChildren();
                signForMoczopedne= !signForMoczopedne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.EXPECTORANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wykrztusne  click");
                    tableInnerScrollable.clearChildren();
                    signForWykrztusne= !signForWykrztusne;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.IMPROVING_DIGESTION, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Pobudzatrawienie  click");
                tableInnerScrollable.clearChildren();
                    tableInnerScrollable.clearChildren();
                    signForPobudzanieTrawienia= !signForPobudzanieTrawienia;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.LAXATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeczyszczajace  click");
                    tableInnerScrollable.clearChildren();
                    signForPrzeczyszczajace= !signForPrzeczyszczajace;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.PROTECTIVE_SCREENING, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Oslaniajace  click");
                    tableInnerScrollable.clearChildren();
                signForOslaniajace= !signForOslaniajace;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.SEDATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Uspokajajace  click");
                    tableInnerScrollable.clearChildren();
                signForUspokajajace= !signForUspokajajace;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.SPASMOLYTIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Rozkurczajace  click");
                    tableInnerScrollable.clearChildren();
                signForRozkurczajace= !signForRozkurczajace;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.URINARY_TRACT_DISINFECTANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Odkazajace drogi moczowe  click");
                    tableInnerScrollable.clearChildren();
                signForOdkazajaceDrogiMoczowe= !signForOdkazajaceDrogiMoczowe;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

    }

    private void testBookmarkTable() {
        tableBookmarkScrollable.row();
        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("TEST scrollable bookmark");
            }
        })).padTop(10f);
    }

    //////////////Getters and Setterrs/////////////

    public static boolean isSignForPrzeciwbakteryjne() {
        return signForPrzeciwbakteryjne;
    }

    public static boolean isSignForPrzeciwkaszlowe() {
        return signForPrzeciwkaszlowe;
    }

    public static boolean isSignForPrzeciwgoraczkowe() {
        return signForPrzeciwgoraczkowe;
    }

    public static boolean isSignForOdkazajaceDrogiMoczowe() {
        return signForOdkazajaceDrogiMoczowe;
    }

    public static boolean isSignForPrzeciwskurczowe() {
        return signForPrzeciwskurczowe;
    }

    public static boolean isSignForSciagajace() {
        return signForSciagajace;
    }

    public static boolean isSignForNiewydolnoscKrazenia() {
        return signForNiewydolnoscKrazenia;
    }

    public static boolean isSignForWiatropedne() {
        return signForWiatropedne;
    }

    public static boolean isSignForZolciopedne() {
        return signForZolciopedne;
    }

    public static boolean isSignForPrzeciwzapalne() {
        return signForPrzeciwzapalne;
    }

    public static boolean isSignForNapotne() {
        return signForNapotne;
    }

    public static boolean isSignForMoczopedne() {
        return signForMoczopedne;
    }

    public static boolean isSignForWykrztusne() {
        return signForWykrztusne;
    }

    public static boolean isSignForPobudzanieTrawienia() {
        return signForPobudzanieTrawienia;
    }

    public static boolean isSignForPrzeczyszczajace() {
        return signForPrzeczyszczajace;
    }

    public static boolean isSignForOslaniajace() {
        return signForOslaniajace;
    }

    public static boolean isSignForUspokajajace() {
        return signForUspokajajace;
    }

    public static boolean isSignForRozkurczajace() {
        return signForRozkurczajace;
    }
}
