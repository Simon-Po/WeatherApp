package weatherapp;

public enum WeatherASCII {
    RAIN("""
                _(  )_( )_
               (_   _    _)
              / /(_) (__)
             / / / / / /
            / / / / / /"""),
    SUN("""
                  ;   :   ;
               .   \\_,!,_/   ,
                `.,'     `.,'
                 /         \\
            ~ -- :         : -- ~
                 \\         /
                ,'`._   _.'`.
               '   / `!` \\   `
                  ;   :   ;"""),
    CLOUDY("""
                      .-~~~-.
              .- ~ ~-(       )_ _
             /                    ~ -.
            |                          ',
             \\                         .'
               ~- ._ ,. ,.,.,., ,.. -~
                       '       '""");


    public final String ASCII;

    WeatherASCII(String ASCII) {
        this.ASCII = ASCII;
    }
}
