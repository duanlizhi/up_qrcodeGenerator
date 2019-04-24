package com.unionpay.qrcode.otherutil;

/**
 * @author homels
 * @date 2019/3/19
 */
public class ConstantString {
    public static String[] paySystem = {"选择支付系统","02Visa","03Visa","04Mastercard","05Mastercard","06EMVCo",
            "07EMVCo","08EMVCo","09Discover","10Discover","11Amex","12Amex","13JCB","14JCB","15UnionPay",
            "16UnionPay"};
    /**
     *  商户类别码
     */
    public static String[] merchantCode = {
            "选择商户类别（MCC码）",
            "5944银器店 ",
            "5094贵重珠宝、首饰，钟表零售（批发商）",
            "5812就餐场所和餐馆 ",
            "5813饮酒场所",
            "5932古玩店－出售、维修及还原",
            "5937古玩复制店 ",
            "5950玻璃器皿和水晶饰品店 ",
            "5970工艺美术商店",
            "5971艺术商和画廊",
            "7011住宿服务",
            "7012分时使用的别墅或度假用房",
            "7032运动和娱乐露营地 ",
            "7033活动房车场及露营场所 ",
            "7631手表、钟表和首饰维修店 ",
            "7829电影和录像创作、发行 ",
            "7911歌舞厅 ",
            "7922戏剧制片、演出和票务 ",
            "7929未列入其他代码的乐队、文艺表演 ",
            "7932台球、撞球场所 ",
            "7933保龄球馆 ",
            "7941商业体育场馆、职业体育俱乐部、运动场和体育推广公司 ",
            "7992公共高尔夫球场 ",
            "7994大型游戏机和游戏场所 ",
            "7996游乐园、马戏团、嘉年华、占卜 ",
            "7997会员俱乐部、乡村俱乐部以及私人高尔夫课程班 ",
            "7998水族馆、海洋馆和海豚馆 ",
            "7999未列入其他代码的娱乐服务",
            "5811包办伙食，宴会承包商 ",
            "7297按摩店 ",
            "7298保健及美容SPA ",
            "5933当铺 ",
            "1520一般承包商－住宅与商业楼",
            "7013不动产代理－房地产经纪 ",
            "5271活动房车经销商 ",
            "5511汽车货车经销商－新旧车的销售、服务、维修、零件及出租",
            "5521汽车货车经销商,旧车的销售、服务、维修、零件及出租 ",
            "5551船只经销商 ",
            "5561旅行拖车、娱乐用车销售商",
            "5571摩托车商店和经销商 ",
            "5592露营、房车销售商 ",
            "5598雪车商 ",
            "5599汽车、飞行器、农用机车综合经营商 ",
            "5441糖果及坚果商店 ",
            "5621妇女成衣商店",
            "5631女性用品商店",
            "5655运动服饰商店",
            "5681皮货店 ",
            "5691成人成衣店 ",
            "5814快餐店 ",
            "5941体育用品店 ",
            "5948箱包、皮具店",
            "5972邮票和纪念币商店 ",
            "5976假肢店（整形外科用品、辅助设备） ",
            "5977化妆品商店 ",
            "5992花店 ",
            "7230美容理发店 ",
            "7832电影院 ",
            "8043光学产品、眼镜店 ",
            "0742兽医服务 ",
            "0763农业合作 ",
            "0780景观美化及园艺服务 ",
            "4011铁路运输 ",
            "4119救护车服务 ",
            "4214货物搬运和托运,以及当地递送服务 ",
            "4215快递服务（空运、地面运输或海运） ",
            "4225公共仓储服务－农产品、冷冻品和家用产品 ",
            "4411轮船及巡游航线服务 ",
            "4457出租船只 ",
            "4468船舶、海运服务提供商 ",
            "4582机场服务 ",
            "4789未列入其他代码的运输服务",
            "4812电信设备和销售（商） ",
            "4816计算机网络/信息服务 ",
            "4821电报服务 ",
            "5211建材和木材",
            "5231玻璃、油漆涂料、墙纸零售",
            "5251五金商店 ",
            "5261草坪、花园用品商店 ",
            "5309免税商店 ",
            "5310折扣商店 ",
            "5311百货商店 ",
            "5331各类杂货店、便利店 ",
            "5399其他综合零售",
            "5422各类肉类零售商 ",
            "5451乳制品店、冷饮店 ",
            "5462面包房、糕点商店 ",
            "5499各类食品店及专门食品零售店 ",
            "5532汽车轮胎经销商 ",
            "5533汽车零配件商店 ",
            "5611男子和男童服装及用品商店",
            "5641婴儿、儿童服装店 ",
            "5651家庭服装商店",
            "5661鞋店 ",
            "5697裁缝、修补、改衣店 ",
            "5698假发商店 ",
            "5699各类服装及饰物店 ",
            "5712家具、家庭摆品、家用设备零售商 ",
            "5713地板商店 ",
            "5714帏帐、窗帘、室内装潢商店",
            "5718壁炉、壁炉防护网及配件商店 ",
            "5719各种家庭装饰专营店 ",
            "5732电子设备商店",
            "5733音乐商店－乐器、钢琴、乐谱 ",
            "5734计算机软件商店 ",
            "5735音像制品商店",
            "5912药店、药房 ",
            "5921瓶装酒零售店",
            "5931旧商品店、二手商品店 ",
            "5935海上船只遇难救助 ",
            "5940自行车商店 ",
            "5942书店 ",
            "5943文具用品商店、各类办公用品商店 ",
            "5945玩具、游戏店",
            "5946照相器材商店",
            "5947礼品、卡片、装饰品、纪念品商店 ",
            "5949纺织品及针织品零售 ",
            "5962旅游相关服务直销 ",
            "5963门对门销售 ",
            "5964目录直销商户",
            "5965目录、零售兼营商户 ",
            "5966电话呼出直销",
            "5967电话呼入直销",
            "5968订阅/订购直销服务 ",
            "5969其他直销商户",
            "5973宗教品商店 ",
            "5975助听器－销售、服务和用品",
            "5978打字机商店－销售、服务和出租 ",
            "5993香烟、雪茄专卖店 ",
            "5995宠物商店、宠物食品及用品",
            "5996游泳池－销售、供应和服务",
            "5997电动剃刀商店－销售和服务",
            "5999其他专门零售店 ",
            "6010金融机构－人工现金支付 ",
            "6011金融机构－自动现金支付 ",
            "6012金融机构－商品和服务 ",
            "6051非金融机构－外币兑换、非电子转帐的汇票、临时支付凭证和旅行支票 ",
            "6211证券公司－经纪人和经销商",
            "6513不动产管理－物业管理 ",
            "7210洗衣店 ",
            "7211洗熨服务（自助洗衣服务）",
            "7216干洗店 ",
            "7217室内清洁服务",
            "7221摄影工作室 ",
            "7251修鞋店、擦鞋店、帽子清洗店 ",
            "7261殡葬服务 ",
            "7273婚姻介绍及陪同服务 ",
            "7276税收准备服务",
            "7277咨询服务－债务、婚姻和私人事务 ",
            "7278购物服务及会所（贸易、经纪服务） ",
            "7295家政服务 ",
            "7296出租衣物－服装、制服和正式场合服装",
            "7299未列入其他代码的个人服务（其他房地产服务） ",
            "7299未列入其他代码的其他个人服务 ",
            "7311广告服务 ",
            "7321消费者信用报告机构 ",
            "7333商业摄影、工艺、绘图服务",
            "7338复印及绘图服务 ",
            "7339速记、秘书服务（包括各类办公服务）",
            "7342灭虫及消毒服务 ",
            "7349清洁、保养及门卫服务 ",
            "7361职业中介、临时工 ",
            "7372计算机编程、数据处理和系统集成设计服务 ",
            "7375信息检索服务",
            "7379未列入其他代码的计算机维护和修理服务 ",
            "7392管理、咨询和公共关系服务",
            "7393侦探、保安、安全服务 ",
            "7394设备、工具、家具和电器出租 ",
            "7395照相洗印服务",
            "7399未列入其他代码的商业服务",
            "7512汽车出租 ",
            "7513卡车及拖车出租 ",
            "7519房车和娱乐车辆出租 ",
            "7531车体维修店 ",
            "7534轮胎翻新、维修店 ",
            "7535汽车喷漆店 ",
            "7538汽车服务商店（非经销商）",
            "7542洗车 ",
            "7549拖车服务 ",
            "7622电器设备维修",
            "7623空调、制冷设备维修 ",
            "7629电器设备、小家电维修 ",
            "7641家具维修、翻新 ",
            "7692焊接维修服务",
            "7699各类维修店及相关服务 ",
            "7841音像制品出租商店 ",
            "7991旅游与展览 ",
            "7993电子游戏供给",
            "7995彩票销售 ",
            "8011其他医疗卫生活动 ",
            "8021牙科医生 ",
            "8031正骨医生 ",
            "8041按摩医生 ",
            "8042眼科医生 ",
            "8049手足病医生 ",
            "8050护理和照料服务 ",
            "8071医学及牙科实验室 ",
            "8099其他医疗保健服务 ",
            "8111法律服务和律师事务所服务",
            "8241函授学校（成人教育） ",
            "8244商业和文秘学校（中等专业学校） ",
            "8249贸易和职业学校（职业技能培训） ",
            "8299其他学校和教育服务 ",
            "8351儿童保育服务（含学前教育） ",
            "8641市民、社会及友爱组织 ",
            "8661宗教组织 ",
            "8675汽车协会 ",
            "8699其他会员组织",
            "8911建筑、工程和测量服务 ",
            "8912装修、装潢、园艺 ",
            "8931会计、审计、务服务 ",
            "8999未列入其他代码的专业服务",
            "5960保险直销 ",
            "6300保险销售、保险业和保险金",
            "4722旅行社 ",
            "4733大型景区售票",
            "5013机动车供应及零配件（批发商） ",
            "5021办公及商务家具（批发商）",
            "5039未列入其他代码的建材批发（批发商）",
            "5044办公、影印及微缩摄影器材（批发商）",
            "5045计算机、计算机外围设备（批发商） ",
            "5046未列入其他代码的商用器材（批发商）",
            "5047牙科/实验室/医疗/眼科医院器材和用品（批发商）",
            "5051金属产品服务商和公司（批发商） ",
            "5065电器零件和设备（批发商）",
            "5072五金器材及用品（批发商）",
            "5074管道和供暖设备（批发商）",
            "5111文具、办公用品、复印纸和书写纸（批发商） ",
            "5122药品、药品经营者（批发商） ",
            "5131布料、缝纫用品和其他纺织品（批发商）",
            "5137男女及儿童制服和服装（批发商） ",
            "5139鞋类（批发商） ",
            "5172石油及石油产品（批发商）",
            "5192书、期刊和报纸（批发商）",
            "5193花木栽种用品、苗木和花卉（批发商）",
            "5198油漆、清漆用品（批发商）",
            "5998其他批发商 ",
            "5398大型企业批发",
            "4458烟草配送",
            "4111本市和市郊通勤旅客运输（包括轮渡）",
            "4112铁路客运 ",
            "4121出租车服务 ",
            "4131公路客运 ",
            "4511航空公司 ",
            "4784路桥通行费 ",
            "4814电信服务，本地和长途电话、信用卡电话、磁卡电话和传真 ",
            "4899有线和其他付费电视服务 ",
            "5411大型仓储式超级市场 （快递、物流）",
            "5541加油站、服务站 ",
            "5542自助加油站 ",
            "5722家用电器商店",
            "8651政治组织（政府机构） ",
            "9211法庭费用，包括赡养费和子女抚养费 ",
            "9222罚款 ",
            "9223保释金 ",
            "9311纳税 ",
            "9399未列入其他代码的政府服务（社会保障服务，国家强制） ",
            "9400使领馆收费 ",
            "5994报亭、报摊 ",
            "9402国家邮政服务",
            "4900公共事业（ 电力、煤气、自来水、清洁服务） ",
            "7523停车场 ",
            "8062公立医院 ",
            "8211中小学校（公立） ",
            "8220普通高校（公立） ",
            "8398慈善和社会公益服务组织 "};

    public static String[] reTra = {
            "选择交易币种",
            "971",
            "012",
            "973",
            "032",
            "051",
            "533",
            "036",
            "944",
            "044",
            "048",
            "764",
            "590",
            "052",
            "974",
            "933",
            "084",
            "060",
            "928",
            "937",
            "068",
            "986",
            "096",
            "975",
            "108",
            "124",
            "132",
            "136",
            "936",
            "952",
            "950",
            "953",
            "152",
            "170",
            "174",
            "976",
            "977",
            "558",
            "188",
            "192",
            "270",
            "208",
            "807",
            "262",
            "678",
            "930",
            "516",
            "214",
            "704",
            "951",
            "818",
            "222",
            "230",
            "978",
            "238",
            "242",
            "348",
            "292",
            "332",
            "600",
            "324",
            "328",
            "344",
            "980",
            "352",
            "356",
            "356",
            "364",
            "368",
            "376",
            "388",
            "400",
            "404",
            "598",
            "203",
            "191",
            "414",
            "967",
            "104",
            "418",
            "981",
            "422",
            "008",
            "340",
            "694",
            "430",
            "434",
            "748",
            "426",
            "969",
            "454",
            "458",
            "480",
            "943",
            "484",
            "498",
            "504",
            "504",
            "984",
            "232",
            "566",
            "524",
            "532",
            "934",
            "643",
            "901",
            "949",
            "554",
            "064",
            "408",
            "578",
            "478",
            "929",
            "776",
            "586",
            "446",
            "931",
            "858",
            "608",
            "826",
            "826",
            "072",
            "634",
            "320",
            "710",
            "512",
            "116",
            "946",
            "462",
            "360",
            "360",
            "646",
            "682",
            "941",
            "690",
            "702",
            "604",
            "090",
            "417",
            "706",
            "972",
            "710",
            "728",
            "144",
            "654",
            "938",
            "968",
            "752",
            "756",
            "760",
            "050",
            "882",
            "834",
            "398",
            "780",
            "496",
            "788",
            "840",
            "784",
            "800",
            "990",
            "970",
            "940",
            "840",
            "860",
            "548",
            "410",
            "886",
            "392",
            "156",
            "932",
            "985"};



    /**
     * 交易货币
     */
    public static String[] transactionCurrency =
            {
                    "选择交易币种",
                    "Afghani(AFN),2",
                    "Algerian Dinar(DZD),2",
                    "Angola Kwanza(AOA),2",
                    "Argentine Peso(ARS),2",
                    "Armenian Dram(AMD),2",
                    "Aruban Guilder(AWG),2",
                    "Australian Dollar(AUD),2",
                    "Azerbaijan Manat(AZN),2",
                    "Bahamian Dollar(BSD),2",
                    "Bahraini Dinar(BHD),3",
                    "Baht(THB),2",
                    "Balboa(PAB),2",
                    "Barbados Dollar(BBD),2",
                    "Belarusian Ruble (old)(BYR),0",
                    "Belarusian Ruble(BYN),2",
                    "Belize Dollar(BZD),2",
                    "Bermudian Dollar(BMD),2",
                    "Bolívar Soberano(VES),2",
                    "Bolívar(VEF),2",
                    "Boliviano(BOB),2",
                    "Brazilian Real(BRL),2",
                    "Brunei Dollar(BND),2",
                    "Bulgarian Lev(BGN),2",
                    "Burundi Franc(BIF),0",
                    "Canadian Dollar(CAD),2",
                    "Cape Verde Escudo(CVE),2",
                    "Cayman Islands Dollar(KYD),2",
                    "Cedi(GHS),2",
                    "CFA Franc BCEAO(XOF),0",
                    "CFA Franc BEAC(XAF),0",
                    "CFP Franc(XPF),0",
                    "Chilean Peso(CLP),0",
                    "Colombian Peso(COP),2",
                    "Comorian Franc(KMF),0",
                    "Congolese Franc(CDF),2",
                    "Convertible Mark(BAM),2",
                    "Cordoba Oro(NIO),2",
                    "Costa Rican Colon(CRC),2",
                    "Cuban Peso(CUP),2",
                    "Dalasi(GMD),2",
                    "Danish Krone(DKK),2",
                    "Denar(MKD),2",
                    "Djibouti Franc(DJF),0",
                    "Dobra (old)(STD),2",
                    "Dobra(STN),2",
                    "Dollar(NAD),2",
                    "Dominican Peso(DOP),2",
                    "Dong(VND),0",
                    "East Caribbean Dollar(XCD),2",
                    "Egyptian Pound(EGP),2",
                    "El Salvador Colon(SVC),2",
                    "Ethiopian Birr(ETB),2",
                    "Euro(EUR),2",
                    "Falkland Islands Pound(FKP),2",
                    "Fiji Dollar(FJD),2",
                    "Forint(HUF),2",
                    "Gibraltar Pound(GIP),2",
                    "Gourde(HTG),2",
                    "Guarani(PYG),0",
                    "Guinean Franc(GNF),0",
                    "Guyana Dollar(GYD),2",
                    "Hong Kong Dollar(HKD),2",
                    "Hryvnia(UAH),2",
                    "Icelandic Krona(ISK),2",
                    "Indian Rupee(INR),2",
                    "Indian Rupee(INR),2",
                    "Iranian Rial(IRR),2",
                    "Iraqi Dinar(IQD),3",
                    "Israeli Shekel(ILS),2",
                    "Jamaican Dollar(JMD),2",
                    "Jordanian Dinar(JOD),3",
                    "Kenyan Shilling(KES),2",
                    "Kina(PGK),2",
                    "Koruna(CZK),2",
                    "Kuna(HRK),2",
                    "Kuwaiti Dinar(KWD),3",
                    "Kwacha(ZMW),2",
                    "Kyat(MMK),2",
                    "Lao Kip(LAK),2",
                    "Lari(GEL),2",
                    "Lebanese Pound(LBP),2",
                    "Lek(ALL),2",
                    "Lempira(HNL),2",
                    "Leone(SLL),2",
                    "Liberian Dollar(LRD),2",
                    "Libyan Dinar(LYD),3",
                    "Lilangeni(SZL),2",
                    "Loti(LSL),2",
                    "Malagasy Ariary(MGA),2",
                    "Malawi Kwacha(MWK),2",
                    "Malaysian Ringgit(MYR),2",
                    "Mauritius Rupee(MUR),2",
                    "Metical(MZN),2",
                    "Mexican Peso(MXN),2",
                    "Moldovan Leu(MDL),2",
                    "Moroccan Dirham(MAD),2",
                    "Moroccan Dirham(MAD),2",
                    "Mvdol(BOV),2",
                    "Nafka(ERN),2",
                    "Naira(NGN),2",
                    "Nepalese Rupee(NPR),2",
                    "Netherlands Antillean Guilder(ANG),2",
                    "New Manat(TMT),2",
                    "New Ruble（Russian Ruble）(RUB),2",
                    "New Taiwan Dollar(TWD),2",
                    "New Turkish Lira(TRY),2",
                    "New Zealand Dollar(NZD),2",
                    "Ngultrum(BTN),2",
                    "North Korean Won(KPW),2",
                    "Norwegian Krone(NOK),2",
                    "Ouguiya (old)(MRO),2",
                    "Ouguiya(MRU),2",
                    "Pa’anga(TOP),2",
                    "Pakistan Rupee(PKR),2",
                    "Pataca(MOP),2",
                    "Peso Convertible(CUC),2",
                    "Peso Uruguayo(UYU),2",
                    "Philippine Peso (PHP),2",
                    "Pound Sterling(GBP),2",
                    "Pound Sterling(GBP),2",
                    "Pula(BWP),2",
                    "Qatari Rial(QAR),2",
                    "Quetzal(GTQ),2",
                    "Rand(ZAR),2",
                    "Rial Omani(OMR),3",
                    "Riel(KHR),2",
                    "Romanian Leu(RON),2",
                    "Rufiyaa(MVR),2",
                    "Rupiah(IDR),2[1]",
                    "Rupiah(IDR),2[2]",
                    "Rwanda Franc(RWF),0",
                    "Saudi Riyal(SAR),2",
                    "Serbian Dinar(RSD),2",
                    "Seychelles Rupee(SCR),2",
                    "Singapore Dollar(SGD),2",
                    "Sol(PEN),2",
                    "Solomon Islands Dollar(SBD),2",
                    "SOM(KGS),2",
                    "Somali Shilling(SOS),2",
                    "Somoni(TJS),2",
                    "South African Rand(ZAR),2",
                    "South Sudanese Pound(SSP),2",
                    "Sri Lanka Rupee(LKR),2",
                    "St. Helena Pound(SHP),2",
                    "Sudanese Pound(SDG),2",
                    "Surinam Dollar(SRD),2",
                    "Swedish Krona(SEK),2",
                    "Swiss Franc(CHF),2",
                    "Syrian Pound(SYP),2",
                    "Taka(BDT),2",
                    "Tala(WST),2",
                    "Tanzanian Shilling(TZS),2",
                    "Tenge(KZT),2",
                    "Trinidad and Tobago Dollar(TTD),2",
                    "Tugrik(MNT),2",
                    "Tunisian Dinar(TND),3",
                    "U.S. Dollar(USD),2",
                    "UAE Dirham(AED),2",
                    "Uganda Shilling(UGX),0",
                    "Unidad de Fomento(CLF),4",
                    "Unidad de Valor Real(COU),2",
                    "Uruguay Peso en Unidades Indexadas (UI)(UYI),0",
                    "US Dollar(USD),2",
                    "Uzbekistan Sum(UZS),2",
                    "Vatu(VUV),0",
                    "Won(KRW),0",
                    "Yemen Rial(YER),2",
                    "Yen(JPY),0",
                    "Yuan Renminbi(CNY),2",
                    "Zimbabwe Dollar(ZWL),2",
                    "Zloty(PLN),2"};



    /**
     * 小费标识
     */
    public static String[] convenienceType = {"00不收取小费","01消费者输入小费金额","02收取固定金额小费","03按百分比收取小费"};
    /**
     * 国家码
     */
    public static String[] countryCode = {
            "选择国家编码",
            "AD安道尔",
            "AE阿拉伯联合酋长国",
            "AF阿富汗",
            "AG安提瓜和巴布达",
            "AI安圭拉",
            "AL阿尔巴尼亚",
            "AM亚美尼亚",
            "AN荷属安的列斯群岛",
            "AO安哥拉",
            "AQ南极洲",
            "AR阿根廷",
            "AS美属萨摩亚",
            "AT奥地利",
            "AU澳大利亚",
            "AW阿鲁巴",
            "AZ阿塞拜疆",
            "BA波斯尼亚和黑塞哥维那",
            "BB巴巴多斯",
            "BD孟加拉国",
            "BE比利时",
            "BF布基纳法索",
            "BG保加利亚",
            "BH巴林",
            "BI布隆迪",
            "BJ贝宁",
            "BM百慕大",
            "BN文莱达鲁萨兰国",
            "BO玻利维亚",
            "BR巴西",
            "BS巴哈马",
            "BT不丹",
            "BV布维岛",
            "BW博茨瓦纳",
            "BY白俄罗斯",
            "BZ伯利兹",
            "CA加拿大",
            "CC科科斯（基林）群岛",
            "CD会刚果民主共和国",
            "CF中非共和国",
            "CG刚果（刚果共和国）",
            "CH瑞士",
            "CI科特迪瓦",
            "CK库克群岛",
            "CL智利",
            "CM喀麦隆",
            "CN中华人民共和国",
            "CO哥伦比亚",
            "CR哥斯达黎加",
            "CS塞尔维亚和黑山",
            "CU古巴",
            "CX圣诞岛",
            "CY塞浦路斯",
            "CZ捷克共和国",
            "DE德国",
            "DJ吉布提",
            "DK丹麦",
            "DM多米尼加",
            "DO多米尼加共和国",
            "DZ阿尔及利亚",
            "EC厄瓜多尔",
            "EE爱沙尼亚",
            "EG埃及",
            "EH西撒哈拉",
            "ER厄立特里亚",
            "ES西班牙",
            "ET埃塞俄比亚",
            "FI芬兰",
            "FJ斐济",
            "FK福克兰群岛",
            "FM密克罗尼西亚联邦",
            "FO法罗群岛",
            "FR法国",
            "GA加蓬",
            "GB英国",
            "GD格林纳达",
            "GE格鲁吉亚",
            "GF法属圭亚那",
            "GH加纳",
            "GI直布罗陀",
            "GL格陵兰岛",
            "GM冈比亚",
            "GN几内亚",
            "GP瓜德罗普岛",
            "GQ赤道几内亚",
            "GR希腊",
            "GS南乔治亚岛和南桑威奇群岛",
            "GT危地马拉",
            "GU关岛",
            "GW几内亚比绍",
            "GY圭亚那",
            "HK香港",
            "HM赫德岛和麦当劳群岛",
            "HN洪都拉斯",
            "HR克罗地亚",
            "HT海地",
            "HU匈牙利",
            "ID印度尼西亚",
            "IE爱尔兰",
            "IL以色列",
            "IN印度",
            "IO英属印度洋领地",
            "IQ伊拉克",
            "IR伊朗",
            "IS冰岛",
            "IT意大利",
            "JM牙买加",
            "JO约旦",
            "JP日本",
            "KE肯尼亚",
            "KG吉尔吉斯斯坦",
            "KH柬埔寨",
            "KI基里巴斯",
            "KM科摩罗",
            "KN圣基茨和尼维斯",
            "KP朝鲜人民民主共和国",
            "KR大韩民国",
            "KW科威特",
            "KY开曼群岛",
            "KZ哈萨克斯坦",
            "LA老挝人民民主共和国",
            "LB黎巴嫩",
            "LC圣卢西亚",
            "LI列支敦士登",
            "LK斯里兰卡",
            "LR利比里亚",
            "LS莱索托",
            "LT立陶宛",
            "LU卢森堡",
            "LV拉脱维亚",
            "LY阿拉伯利比亚民众国",
            "MA摩洛哥",
            "MC摩纳哥",
            "MD摩尔多瓦",
            "MG马达加斯加",
            "MH马绍尔群岛",
            "MK前南斯拉夫的马其顿共和国",
            "ML马里",
            "MM缅甸",
            "MN蒙古",
            "MO澳门",
            "MP北马里亚纳群岛",
            "MQ马提尼克岛",
            "MR毛里塔尼亚",
            "MS蒙特塞拉特",
            "MT马耳他",
            "MU毛里求斯",
            "MV马尔代夫",
            "MW马拉维",
            "MX墨西哥",
            "ME马来西亚",
            "MZ莫桑比克",
            "NA纳米比亚",
            "NC新喀里多尼亚",
            "NE尼日尔",
            "NF诺福克岛",
            "NG尼日利亚",
            "NI尼加拉瓜",
            "NL荷兰",
            "NO挪威",
            "NP尼泊尔",
            "NR瑙鲁",
            "NU纽埃",
            "NZ新西兰",
            "OM阿曼",
            "PA巴拿马",
            "PE秘鲁",
            "PF法属波利尼西亚",
            "PG巴布亚新几内亚",
            "PH菲律宾",
            "PK巴基斯坦",
            "PL波兰",
            "PM圣皮埃尔和密克隆",
            "PN皮特凯恩群岛",
            "PR波多黎各",
            "PS巴勒斯坦被占领土",
            "PT葡萄牙",
            "PW帕劳",
            "PY巴拉圭",
            "QA卡塔尔",
            "RO罗马尼亚",
            "RU俄罗斯",
            "RW卢旺达",
            "SA沙特阿拉伯",
            "SB所罗门群岛",
            "SC塞舌尔",
            "SD苏丹",
            "SE瑞典",
            "SG新加坡",
            "SH圣赫勒拿",
            "SI斯洛文尼亚",
            "SJ斯瓦尔巴和扬马延群岛",
            "SK斯洛伐克",
            "SL塞拉利昂",
            "SM圣马力诺",
            "SN塞内加尔",
            "SO索马里",
            "SR苏里南",
            "ST圣多美和普林西比",
            "SV萨尔瓦多",
            "SY阿拉伯叙利亚共和国",
            "SZ斯威士兰",
            "TC特克斯和凯科斯群岛",
            "TD乍得",
            "TF法属南部领土",
            "TG多哥",
            "TH泰国",
            "TJ塔吉克斯坦",
            "TK托克劳",
            "TL东帝汶",
            "TM土库曼斯坦",
            "TN突尼斯",
            "TO汤加",
            "TR土耳其",
            "TT特立尼达和多巴哥",
            "TV图瓦卢",
            "TW台湾，中国 ",
            "TZ坦桑尼亚联合共和国",
            "UA乌克兰",
            "UG乌干达",
            "UM美国本土外小岛屿",
            "US美国",
            "UY乌拉圭",
            "UZ乌兹别克斯坦",
            "VA罗马教廷（梵蒂冈城）",
            "VC圣文森特和格林纳丁斯",
            "VE委内瑞拉",
            "VG英属维尔京群岛",
            "VI美属维尔京群岛",
            "VN越南（越南）",
            "VU瓦努阿图",
            "WF瓦利斯和富图纳群岛",
            "WS萨摩亚",
            "YE也门",
            "YT马约特岛",
            "ZA南非",
            "ZM赞比亚",
            "ZW津巴布韦"};

    /**
     * 语言首选项
     */
    public static String[] penferenceLanguage = {
            "选择语言编码",
            "sq (Albanian)",
            "am (Amharic)",
            "ar (Arabic)",
            "aa (Afar)",
            "hy (Armenian)",
            "ay (Aymara)",
            "as (Assamese)",
            "az (Azerbaijani)",
            "ba (Bashkir)",
            "eu (Basque)",
            "bn (Bengali (Bangla))",
            "af (Afrikaans)",
            "dz (Bhutani)",
            "bh (Bihari)",
            "bi (Bislama)",
            "br (Breton)",
            "bg (Bulgarian)",
            "my (Burmese)",
            "be (Byelorussian (Belarusian))",
            "km (Cambodian)",
            "ca (Catalan)",
            "zh (Chinese (Simplified))",
            "zh (Chinese (Traditional))",
            "co (Corsican)",
            "hr (Croatian)",
            "cs (Czech)",
            "da (Danish)",
            "nl (Dutch)",
            "eo (Esperanto)",
            "en (English)",
            "et (Estonian)",
            "fo (Faeroese)",
            "fa (Farsi)",
            "fj (Fiji)",
            "fi (Finnish)",
            "fy (Frisian)",
            "gl (Galician)",
            "gd (Gaelic (Scottish))",
            "gv (Gaelic (Manx))",
            "ka (Georgian)",
            "el (Greek)",
            "de (German)",
            "kl (Greenlandic)",
            "gu (Gujarati)",
            "ha (Hausa)",
            "he (Hebrew)",
            "fr (French)",
            "gn (Guarani)",
            "hi (Hindi)",
            "hu (Hungarian)",
            "is (Icelandic)",
            "id (Indonesian)",
            "ia (Interlingua)",
            "iu (Inuktitut)",
            "ie (Interlingue)",
            "ik (Inupiak)",
            "ga (Irish)",
            "it (Italian)",
            "ja (Japanese)",
            "ja (Javanese)",
            "kn (Kannada)",
            "ks (Kashmiri)",
            "rw (Kinyarwanda (Ruanda))",
            "rn (Kirundi (Rundi))",
            "ky (Kirghiz)",
            "ko (Korean)",
            "ku (Kurdish)",
            "lo (Laothian)",
            "la (Latin)",
            "lv (Latvian (Lettish))",
            "Limburger) (Limburgish ()",
            "ln (Lingala)",
            "lt (Lithuanian)",
            "mk (Macedonian)",
            "mg (Malagasy)",
            "ms (Malay)",
            "ml (Malayalam)",
            "mt (Maltese)",
            "mi (Maori)",
            "mr (Marathi)",
            "mo (Moldavian)",
            "mn (Mongolian)",
            "na (Nauru)",
            "ne (Nepali)",
            "no (Norwegian)",
            "oc (Occitan)",
            "or (Oriya)",
            "Galla) (Oromo (Afan,)",
            "ps (Pashto (Pushto))",
            "pl (Polish)",
            "pt (Portuguese)",
            "pa (Punjabi)",
            "qu (Quechua)",
            "rm (Rhaeto-Romance)",
            "ro (Romanian)",
            "ru (Russian)",
            "sm (Samoan)",
            "sg (Sangro)",
            "sa (Sanskrit)",
            "sr (Serbian)",
            "sh (Serbo-Croatian)",
            "st (Sesotho)",
            "tn (Setswana)",
            "sn (Shona)",
            "sd (Sindhi)",
            "si (Sinhalese)",
            "ss (Siswati)",
            "sk (Slovak)",
            "sl (Slovenian)",
            "so (Somali)",
            "es (Spanish)",
            "su (Sundanese)",
            "sw (Swahili (Kiswahili))",
            "sv (Swedish)",
            "tl (Tagalog)",
            "tg (Tajik)",
            "ta (Tamil)",
            "tt (Tatar)",
            "te (Telugu)",
            "th (Thai)",
            "bo (Tibetan)",
            "ti (Tigrinya)",
            "to (Tonga)",
            "ts (Tsonga)",
            "tr (Turkish)",
            "tk (Turkmen)",
            "tw (Twi)",
            "ug (Uighur)",
            "uk (Ukrainian)",
            "ur (Urdu)",
            "uz (Uzbek)",
            "vi (Vietnamese)",
            "vo (Volapük)",
            "wo (Wolof)",
            "cy (Welsh)",
            "xh (Xhosa)",
            "yi (Yiddish)",
            "yo (Yoruba)",
            "zu (Zulu)",
            "kk (Kazakh)"
    };
}