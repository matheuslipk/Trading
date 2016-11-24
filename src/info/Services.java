package info;

import net.mercadobitcoin.common.exception.MercadoBitcoinException;
import net.mercadobitcoin.tradeapi.service.ApiService;
import net.mercadobitcoin.tradeapi.service.TradeApiService;

/**
 *
 * @author M47
 */
public class Services {
    private static TradeApiService TAPI;   
    public static ApiService API;
    
    public static void setTAPI(String segredo, String Identificador) throws MercadoBitcoinException{
        TAPI = new TradeApiService(segredo, Identificador);
    }
    
    public static TradeApiService getTAPI(){
        return TAPI;
    }
    
    
}