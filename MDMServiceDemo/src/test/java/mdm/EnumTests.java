package mdm;

import mdm.devices.RoleType;

public class EnumTests
{
    public static void main(String[] args)
    {
        RoleType type = RoleType.GSM;
        System.out.println(type + " " +  type.getValue());
    }
}
