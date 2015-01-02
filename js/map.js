$(document).ready(function(e) {

        $("#open-map").click(function(){
            
            console.log("modal opened");
            // wait until the modal transition is done
            $(".modal-dialog").one($.support.transition.end, function(){
                $('#opera_kartta_hotspots').mapster({
                    onClick: function(e) {
                        console.log("open tooltip");
                        $(this).mapster('tooltip');
                    },
                    toolTipClose: "tooltip-click",
                    fillColor: 'ff0000',
                    fillOpacity: 0.3,
                    singleSelect: true,
                    clickNavigate: true,
                    //isSelectable: true,
                    //showToolTip: true,
                    mapKey: "group"
                    /*areas: [
                        {
                            key: 'koti',
                            toolTip: 'Tutustu oopperan tämän hetkiseen tilanteeseen.<br><br><a href="index.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'parvi',
                            toolTip: 'Selvitä minkälainen etiketti oopperaan liityy.<br><br><a href="etiketti.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'permanto',
                            toolTip: 'Ooperalla on tarjota paljon erilaista aktiviteettia myös lapsille!<br><br><a href="lapsille.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'orkesteri',
                            toolTip: 'Baletti on osa oopperaa.<br><br><a href="baletti.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'lava',
                            toolTip: 'Kuuntele pätkiä tunnetuimmista oopperoista ja katso videoita niistä.<br><br><a href="tunnetuimmat.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'kulissit',
                            toolTip: 'Tutustu mitä kaikkea vaaditaan oopperan tekemiseen.<br><br><a href="dokumentti.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        },
                        {
                            key: 'puvustamo',
                            toolTip: 'Oopperalla on pitkä historia Suomessa.<br><br><a href="historia.html"><button class="btn btn-default">Katso sivu!</button></a>',
                        }
                    ]*/
                    
                });
                
                $(window).resize(function(){
                    // make map responsive
                    $('#opera_kartta_hotspots').mapster('resize', $('#kartta').width() );
                });
            }); 
        });
        
    });