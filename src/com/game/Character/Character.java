package com.game.Character;

/**
 * by SwallowJoe
 *
 */
public class Character {

    public String TAG="Character";

    //The name of this character
    protected String mName;
    //The name of this character's type
    private TypeName mTypeName;

    private CharacterParams mParams;

    //Please add more
    public enum TypeName{
        Default,
        Player,
        NPC
    };
    public Character(){
        mName="default";
        mTypeName=TypeName.Default;
        this.mParams=new CharacterParams();
    }

    public Character(CharacterParams params){
        mName="default";
        mTypeName=TypeName.Default;
        this.mParams=params;
    }
}
