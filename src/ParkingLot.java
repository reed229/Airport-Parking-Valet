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

    public double calculateExtraServiceFee() {
        double extraServiceFee = 0.0;
        if (extraService.equalsIgnoreCase("Polish")) {
            extraServiceFee = 65.0;
        } else if (extraService.equalsIgnoreCase("Vacuuming")) {
            extraServiceFee = 25.0;
        } else if (extraService.equalsIgnoreCase("Full car wash(Exterior & Interior)")) {
            extraServiceFee = 75.0;
        }
        return extraServiceFee;
    }

    public double calculateSecurityFee() {
        double securityFee = 0.0;
        if (levelOfSecurity.equalsIgnoreCase("Low")) {
            securityFee = 20.0;
        } else if (levelOfSecurity.equalsIgnoreCase("Medium")) {
            securityFee = 50.0;
        } else if (levelOfSecurity.equalsIgnoreCase("High")) {
            securityFee = 100.0;
        }
        return securityFee;
    }
    
    @Override
    public String toString() {
        return"levelOfSecurity: " + levelOfSecurity + 
              "\nfloorLevel: " + floorLevel + 
              "\nfloorSection: " + floorSection + 
              "\nextraService: " + extraService;
    }

}
