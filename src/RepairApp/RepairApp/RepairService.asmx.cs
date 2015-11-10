using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace RepairApp
{
    /// <summary>
    /// Summary description for RepairService
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class RepairService : System.Web.Services.WebService
    {

        [WebMethod]
        public Boolean naprawProdukt(int idProduktu, int stan)
        {
            Boolean status = false;
            if(stan == 6)
            {
                //Produkt produkt = Magazyn.wezProdukt(idProduktu, stan);
                //if(produkt!=null)
                //{  
                //  Magazyn.umiescProdukt(idProduktu, 4);
                //  status = true;
                //}
                status = true;
            }
            return status;
        }
    }
}
