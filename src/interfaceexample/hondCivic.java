package interfaceexample;

public class hondCivic implements car,fourWheeler{
    @Override
    public String drive() {
        return "drive";
    }

    @Override
    public String accelerate() {
        return "accerlate";
    }

    @Override
    public String brake() {
        return "brake";
    }

    @Override
    public String getSpeed() {
        return "100";
    }

    @Override
    public String getPetrolInfo() {
        return "full";
    }
}
