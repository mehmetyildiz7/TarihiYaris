package com.example.karahan.tarihiyaris;

import com.google.android.gms.flags.Flag;

public class sorular {

    //resim yolu,soru başlığı ,cevap yazısı(cevapları),ipucları
    private int SoruId;
    private String a;
    private String b;
    private String c;
    private String d;
    private String cevap;
    private String ipucu;
    private String soru;

public String getCevap()
{
    return cevap;
}

public void setCevap(String cvp)
{
    this.cevap=cvp;
}
public String getA()
{
    return a;
}
public  void setA(String aa)
{
    this.a=aa;
}
public void setB(String bb)
{
    this.b=bb;
}
public  String getB()
{
    return  b;
}
public String getC()
{
    return c;
}
public void setC(String cc)
{
    this.c=cc;
}
public String getD()
{
    return d;
}
public void setD(String dd)
{
    this.d=dd;
}
public void setIpucu(String ipucuu)
{
    this.ipucu=ipucuu;
}
public String getIpucu()
{
    return ipucu;
}

public int getSoruId()
{
    return SoruId;
}
public  void  setSoruId(int cc)
{
    this.SoruId=cc;
}
public String getSoru()
{
    return  soru;
}
public  void  setSoru(String ss)
{
    this.soru=ss;
}




    sorular()
    {

    }




}
