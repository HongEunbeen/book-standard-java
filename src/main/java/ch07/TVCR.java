package ch07;

class VCR{
    boolean power;
    int counter = 0;
    void power(){power = !power;}
    void play(){/* 내용 생략 */}
    void stop(){/* 내용 생략 */}
    void rew(){/* 내용 생략 */}
    void ff(){/* 내용 생략 */}
}

public class TVCR extends Tv{
    VCR vcr = new VCR();

    void play(){
        vcr.play();
    }
}
