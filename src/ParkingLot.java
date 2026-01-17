package src;
//Copyright (c) 2026 Fareed

public class ParkingLot {
    private String levelOfSecurity;
    private int floorLevel;
    private String floorSection;
    private String extraService;

    public ParkingLot() {
        this.levelOfSecurity = "";
        this.floorLevel = 0;
        this.floorSection = "";
        this.extraService = "";
    }

    public ParkingLot(String LevelOfSecurity, int FloorLevel, String FloorSection, String ExtraService) {
        this.levelOfSecurity = LevelOfSecurity;
        this.floorLevel = FloorLevel;
        this.floorSection = FloorSection;
        this.extraService = ExtraService;
    }
    public void setParkingLot(String LevelOfSecurity, int FloorLevel, String FloorSection, String ExtraService) {
        this.levelOfSecurity = LevelOfSecurity;
        this.floorLevel = FloorLevel;
        this.floorSection = FloorSection;
        this.extraService = ExtraService;
    }
    public String getLevelOfSecurity() {return levelOfSecurity;}
    public int getFloorLevel() {return floorLevel;}
    public String getFloorSection() {return floorSection;}
    public String getExtraService() {return extraService;}
    
    @Override
    public String toString() {
        return "\nPARKINGLOT INFORMATION: " + 
            "\nlevelOfSecurity: " + levelOfSecurity + 
           "\nfloorLevel: " + floorLevel + 
           "\nfloorSection: " + floorSection + 
           "\nextraService: " + extraService;
    }

}
