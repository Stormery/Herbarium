package com.stormery.herbarium.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.stormery.herbarium.buttons.UseButton;
import com.stormery.herbarium.herbs.Aloe;
import com.stormery.herbarium.screens.EnumTherapeuticProperties;

/**
 * Created by Ayo on 2017-08-16.
 */

public class MainScreenTableContainer {
    /////Tables
    private Table tableMain;
    private Table tableBookmarkScrollable;
    private Table tableRight;
    public static Table tableInnerScrollable;
    private boolean tableDebug = false;

    private Stage stage;


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

    public MainScreenTableContainer(Stage stage) {
        this.stage = stage;
        initTable();
    }

    private void initTable() {
        //TODO zmienic skin i Atlas
        Image tableLogo = new Image(new Texture("backgroundImg/Logo.png"));

//InstantiateTables
        tableMain = new Table();
        tableRight = new Table();
//FillParent
        tableMain.setFillParent(true);
//Debug
        tableMain.setDebug(tableDebug);
        tableRight.setDebug(tableDebug);
        //tableUsageType.setDebug(tableDebug);
//Set MainTable position
        tableMain.top().left().padRight(25f).padTop(10f);
//Bookmark scrollable
        tableBookmarkScrollable();
//LOGO
        tableRight.add(tableLogo).height(152f).top(); //LOGO
        tableRight.row();
        tableMain.add(tableRight).top().left();
        //TODO wyszukiwarki nie ma
       // tableMain.add().height(30f).colspan(2); // wyszukiwarka

//Instantiate Box with Therapeutic use Buttons
        tableWithTherapeuticUseTypes();
//Instantiate Box with ScrollableButtons
        tableInnerWithScrollableHerbs();
        stage.addActor(tableMain);
    }

    private void tableBookmarkScrollable() {

        tableBookmarkScrollable = new Table();
        tableBookmarkScrollable.setDebug(tableDebug);
        ScrollPane scrollPane = new ScrollPane(tableBookmarkScrollable);
        scrollPane.setOverscroll(false, false);

        tableMain.add(scrollPane).top().left().width(90f).height(550f)
                .padLeft(15f).padRight(20f).padBottom(5f).padTop(100f);//bookmark
    }

    private void tableInnerWithScrollableHerbs() {
        tableInnerScrollable = new Table();
        tableInnerScrollable.setDebug(tableDebug);

        ScrollPane scrollPane = new ScrollPane(tableInnerScrollable);
        scrollPane.setOverscroll(false, false);

        //tableMain.row();
        tableRight.add(scrollPane).colspan(2).top();

    }

    private void tableWithTherapeuticUseTypes() {
        float therapeuticUsePadTop = 20f;
        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIBACTERIAL, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwbakt click");
                tableInnerScrollable.clearChildren();
                    signForPrzeciwbakteryjne=  signForPrzeciwbakteryjne ?  false :  true;
            }
        })).top().left().padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTIPYRETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("przeciwgoraczkowe click");
                tableInnerScrollable.clearChildren();
                    signForPrzeciwgoraczkowe=  signForPrzeciwgoraczkowe ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTISPASMODIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwskurczowe  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwskurczowe=  signForPrzeciwskurczowe ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ANTITUSSIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwkaszlowe  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwkaszlowe=  signForPrzeciwkaszlowe ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.ASTRINGENTS, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Sciagajace  click");
                tableInnerScrollable.clearChildren();
                signForSciagajace=  signForSciagajace ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CARDIAC_INSUFFICIENCY, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("NiewydolnoscKrazenia  click");
                tableInnerScrollable.clearChildren();
                signForNiewydolnoscKrazenia=  signForNiewydolnoscKrazenia ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CARMINATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wiatropedne  click");
                tableInnerScrollable.clearChildren();
                signForWiatropedne=  signForWiatropedne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.CHOLAGOGUES, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Zolciopedne  click");
                tableInnerScrollable.clearChildren();
                signForZolciopedne=  signForZolciopedne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DEMULCENT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeciwzapalne  click");
                tableInnerScrollable.clearChildren();
                signForPrzeciwzapalne=  signForPrzeciwzapalne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DIAPHORETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Napotne  click");
                tableInnerScrollable.clearChildren();
                signForNapotne=  signForNapotne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.DIURETIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Moczopednt click");
                tableInnerScrollable.clearChildren();
                signForMoczopedne=  signForMoczopedne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.EXPECTORANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Wykrztusne  click");
                    tableInnerScrollable.clearChildren();
                    signForWykrztusne=  signForWykrztusne ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.IMPROVING_DIGESTION, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Pobudzatrawienie  click");
                tableInnerScrollable.clearChildren();
                    tableInnerScrollable.clearChildren();
                    signForPobudzanieTrawienia=  signForPobudzanieTrawienia ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.LAXATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Przeczyszczajace  click");
                    tableInnerScrollable.clearChildren();
                    signForPrzeczyszczajace=  signForPrzeczyszczajace ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.PROTECTIVE_SCREENING, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Oslaniajace  click");
                    tableInnerScrollable.clearChildren();
                signForOslaniajace=  signForOslaniajace ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.SEDATIVE, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Uspokajajace  click");
                    tableInnerScrollable.clearChildren();
                signForUspokajajace=  signForUspokajajace ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.SPASMOLYTIC, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Rozkurczajace  click");
                    tableInnerScrollable.clearChildren();
                signForRozkurczajace=  signForRozkurczajace ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();

        tableBookmarkScrollable.add(new UseButton(EnumTherapeuticProperties.URINARY_TRACT_DISINFECTANT, new IClickCallback() {
            @Override
            public void onClick() {
                System.out.println("Odkazajace drogi moczowe  click");
                    tableInnerScrollable.clearChildren();
                signForOdkazajaceDrogiMoczowe=  signForOdkazajaceDrogiMoczowe ?  false :  true;
            }
        })).padTop(therapeuticUsePadTop);
        tableBookmarkScrollable.row();


//	bttPrzeciwbakt = new HerbImage("buttons/TypeOfTherapeuticUse/PrezciwbaktButton.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny przeciwbakteryjne");
//				//addPrzeciwbakteryjneHerbstoList();
//			}
//		}, herbarium);
//
//		tableUsageType.add(bttPrzeciwbakt).pad(20);
//		/////////////////////////////////
//		bttPrzeciwzap = new HerbImage("buttons/TypeOfTherapeuticUse/PrzeciwZapButtone.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny przeciwzapalne");
//				//addPrzeciwzapalneHerbsToList();
//				herbList.add(enumHerb.RUMIANEK); //test
//				initHerbs();
//
//			}
//		}, herbarium);
//		tableUsageType.add(bttPrzeciwzap).pad(20);
//		//////////////////////////////////////
//		bttMoczopedne = new HerbImage("buttons/TypeOfTherapeuticUse/MoczopedneButton.png", new IClickCallback() {
//
//			@Override
//			public void onClick() {
//				System.out.println("rosliny Moczopedne");
//				//addMoczopedneHerbsToList();
//				herbList.add(enumHerb.POKRZYWA);//test
//				initHerbs();
//			}
//		}, herbarium);
//		tableUsageType.add(bttMoczopedne).pad(20);
        ////////////////////////////////////

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
