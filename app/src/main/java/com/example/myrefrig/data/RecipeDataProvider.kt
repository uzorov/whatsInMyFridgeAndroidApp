package com.example.myrefrig.data

import com.example.myrefrig.data.model.Ingridient
import com.example.myrefrig.data.model.Recipe

object RecipeDataProvider {
    val recepies = mutableListOf<Recipe>(
        Recipe(
            id = 1,
            description = "1. Взбить миксером творог, сахарную пудру и масло. Добавить ванилин и " +
                    "влить растворенный желатин. Поставить в холодильник на 4–5 часов\n 2. Растолочь " +
                    "овсяное печенье и смешать с растопленным шоколадом. Сформовать лепешку и поставить " +
                    "в холодильник на 1 час.\n",
            calories = 861,
            title = "Австралийский чизкейк",
            imageURL = "https://eda.ru/img/eda/c1240x830/s1.eda.ru/StaticContent/Photos/120213175333/1202131754322/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 1,
                    name = "Творог",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328133019/p_O.jpg"
                ),
                Ingridient(
                    id = 2,
                    name = "Сливочное масло",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131111936/120902211454/p_O.jpg"
                ),
                Ingridient(
                    id = 3,
                    name = "Желатин",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131082933/120911122541/p_O.jpg"
                ),
                Ingridient(
                    id = 4,
                    name = "Ванилин",
                    amount_of_weeks_until_expired = 96,
                    image = "https://basket-04.wb.ru/vol458/part45891/45891796/images/big/1.jpg"
                ),
                Ingridient(
                    id = 5,
                    name = "Сахарная пудра",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://yar-vkus.ru/wa-data/public/shop/products/20/09/920/images/3717/saharnaya_pudra.750@2x.jpg"
                ),
                Ingridient(
                    id = 6,
                    name = "Овсяное печенье",
                    amount_of_weeks_until_expired = 3,
                    image = "https://s1.eda.ru/StaticContent/Photos/120213175333/120213175428/p_O.jpg"
                ),
                Ingridient(
                    id = 7,
                    name = "Шоколад",
                    amount_of_weeks_until_expired = 24,
                    image = "https://static.insales-cdn.com/files/1/3228/11226268/original/mceclip0-1580992808851.jpg"
                ),
                Ingridient(
                    id = 8,
                    name = "Джем",
                    amount_of_weeks_until_expired = 48,
                    image = "https://rutxt.ru/files/2514/original/izobrazhenie_22125a.jpg"
                ),
            )
        ),

        //2
        Recipe(
            id = 2,
            description = "Все перемешать, выложить в форму. Выпекать в духовке при температуре 180 градусов.",
            calories = 544,
            title = "Творожный кекс",
            imageURL = "https://prostokvashino.ru/upload/iblock/b1b/b1b727e06d8f0b23c6ea5e8f31c7df0f.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 1,
                    name = "Творог",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328133019/p_O.jpg"
                ),
                Ingridient(
                    id = 2,
                    name = "Сливочное масло",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131111936/120902211454/p_O.jpg"
                ),
                Ingridient(
                    id = 9,
                    name = "Сметана",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328132715/p_O.jpg"
                ),
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 11,
                    name = "Пшеничная мука",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131085333/120403130155/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Сахар",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328130714/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 13,
                    name = "Сода",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/130104145234/130115165516/p_O.jpg"
                ),
            )
        ),
//3
        Recipe(
            id = 3,
            description = "1. Шоколад вместе со сливочным маслом растопить на водяной бане.\n" +
                    "2. Смешать яйца со ста граммами коричневого сахара.\n" +
                    "3. Порубить грецкие орехи\n" +
                    "4. В шоколад со сливочным маслом добавить муку и орехи и все перемешать венчиком.\n" +
                    "5. Влить сахарно-яичную смесь и тщательно смешать" +
                    "6. Поставить в духовку и выпекать 25 - 30 минут до появления " +
                    "сахарной корочки.",
            calories = 676,
            title = "Брауни",
            imageURL = "https://art-lunch.ru/content/uploads/2019/08/brownie_01.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 7,
                    name = "Шоколад",
                    amount_of_weeks_until_expired = 24,
                    image = "https://static.insales-cdn.com/files/1/3228/11226268/original/mceclip0-1580992808851.jpg"
                ),
                Ingridient(
                    id = 2,
                    name = "Сливочное масло",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131111936/120902211454/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Сахар",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328130714/p_O.jpg"
                ),
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 11,
                    name = "Пшеничная мука",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131085333/120403130155/p_O.jpg"
                ),
                Ingridient(
                    id = 14,
                    name = "Грецкие орехи",
                    amount_of_weeks_until_expired = 40,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131084342/120327135226/p_O.jpg"
                ),
            )
        ),

        //4
        Recipe(
            id = 4,
            description = "1. Смешать творог, яйца, сахар. Добавить полстакана муки. \n" +
                    "2. Тесто обвалять в муке\n" +
                    "3. Сделать из теста колбаски, нарезать на кусочки.\n" +
                    "4. Опускать в кипящую подсоленную воду и варить 3 минуты после всплытия.",
            calories = 312,
            title = "Ленивые вареники с творогом",
            imageURL = "https://eda.ru/img/eda/c930x622/s1.eda.ru/StaticContent/Photos/140601161438/140617120605/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 12,
                    name = "Сахар",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328130714/p_O.jpg"
                ),
                Ingridient(
                    id = 1,
                    name = "Творог",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328133019/p_O.jpg"
                ),
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 11,
                    name = "Пшеничная мука",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131085333/120403130155/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                )
            )
        ),
//5
        Recipe(
            id = 5,
            description = "Шаг 1\n" +
                    "Куриное филе для запеканки вымойте, обсушите и нарежьте кубиками небольшого размера. В миске соедините 2 ст. л. сметаны и горчицу. Добавьте немного любых специй, а также соль и перец по вкусу. Перемешайте.\n" +
                    "Шаг 2\n" +
                    "В получившийся маринад положите нарезанное куриное филе. Перемешайте и закройте емкость. Оставьте куриное филе для маринования на 20 минут при комнатной температуре.\n" +
                    "Шаг 3\n" +
                    "Лук для запеканки очистите и нарежьте маленькими кубиками. В сковороде нагрейте растительное масло и, помешивая, подрумяньте лук до золотистого цвета на среднем огне.\n" +
                    "Шаг 4\n" +
                    "Кабачки вымойте и, не очищая, натрите на крупной терке. Оставьте на 10-15 минут, затем отожмите сок. Тертые кабачки соедините с куриным филе. Добавьте яйца, жареный лук и муку. Перемешайте.\n" +
                    "Шаг 5\n" +
                    "Духовку нагрейте до 180°C. Получившуюся кабачковую массу с курицей выложите в форму для запекания, смазанную любым жиром. Готовьте в духовке 30 минут.\n" +
                    "Шаг 6\n" +
                    "Сыр натрите на крупной терке. Осторожно достаньте форму с почти готовой запеканкой из духовки. Посыпьте тертым сыром и готовьте еще 10 минут до золотистой корочки.",
            calories = 258,
            title = "Запеканка с курицей и кабачками",
            imageURL = "https://cdn.botanichka.ru/wp-content/uploads/2018/08/zapekanka-iz-kabachkov-s-kuritsey-02.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 15,
                    name = "Филе куриной грудки",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c930x622/s1.eda.ru/StaticContent/Photos/140524182915/140530160514/p_O.jpg.webp"
                ),
                Ingridient(
                    id = 16,
                    name = "Кабачки",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214130615/120327170200/p_O.jpg"
                ),
                Ingridient(
                    id = 1,
                    name = "Творог",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328133019/p_O.jpg"
                ),
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 17,
                    name = "Сливки",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120830122212/120910144527/p_O.jpg"
                ),
                Ingridient(
                    id = 18,
                    name = "Сыр",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/121220162751/121228225827/p_O.jpg"
                ),
                Ingridient(
                    id = 11,
                    name = "Пшеничная мука",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131085333/120403130155/p_O.jpg"
                ),
                Ingridient(
                    id = 19,
                    name = "Лук репчатый",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083110/120911123915/p_O.jpg"
                ),
                Ingridient(
                    id = 20,
                    name = "Чеснок",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083826/120327133119/p_O.jpg"
                ),
                Ingridient(
                    id = 21,
                    name = "Молотый черный перец",
                    amount_of_weeks_until_expired = 48,
                    image = "https://img.sunfruits.ru/images/products/1/7212/152927276/09e-640x640.jpg"
                ),
                Ingridient(
                    id = 13,
                    name = "Сода",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/130104145234/130115165516/p_O.jpg"
                ),
            )
        ),

        //6
        Recipe(
            id = 6,
            description = "1. Сварить куриный бульон, положив помимо курицы порезанную морковь, соль, " +
                    "перец и сухие укроп и петрушку.\n" +
                    "2. Кабачки очистить и крупно порезать. Положить их в кипящий бульон и варить на " +
                    "маленьком огне минут 10 \n" +
                    "3. Процедить бульон или достать овощи шумовкой. Взбить овощи в блендере " +
                    "до однородной массы. Разложить массу в тарелки, влить бульон и аккуратно перемешать.",
            calories = 100,
            title = "Суп-пюре из кабачков с зеленью",
            imageURL = "https://eda.ru/img/eda/c930x622/s1.eda.ru/StaticContent/Photos/120213180745/120213181019/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(

                Ingridient(
                    id = 16,
                    name = "Кабачки",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214130615/120327170200/p_O.jpg"
                ),

                Ingridient(
                    id = 22,
                    name = "Куриный бульон",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120214131251/140824234958/p_O.jpg"
                ),
                Ingridient(
                    id = 23,
                    name = "Петрушка",
                    amount_of_weeks_until_expired = 48,
                    image = "https://m.dom-eda.com/uploads/images/catalog/item/5ad9ef9fe7/2a55abbcb4_1000.jpg"
                ),
                Ingridient(
                    id = 24,
                    name = "Морковь",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173231/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 21,
                    name = "Молотый черный перец",
                    amount_of_weeks_until_expired = 48,
                    image = "https://img.sunfruits.ru/images/products/1/7212/152927276/09e-640x640.jpg"
                ),
                Ingridient(
                    id = 25,
                    name = "Укроп",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131220/p_O.jpg"
                ),
            )
        ),

        //7
        Recipe(
            id = 7,
            description = "1. Разрезать кабачки вдоль и выложить на противень. Посыпать смесью " +
                    "трав, посолить, посыпать тертым сыром.\n" +
                    "2. Запекать в духовке при 200 градусах 15–20 минут.",
            calories = 343,
            title = "Кабачки, запеченные с сыром",
            imageURL = "https://ont.by/uploads/wysiwyg/images/zrorE64jsj2BrrDb.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 16,
                    name = "Кабачки",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214130615/120327170200/p_O.jpg"
                ),
                Ingridient(
                    id = 18,
                    name = "Сыр",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/121220162751/121228225827/p_O.jpg"
                ),
                Ingridient(
                    id = 25,
                    name = "Смесь пряных трав",
                    amount_of_weeks_until_expired = 48,
                    image = "https://zkrasa.ru/images/shop_items/352.jpg.webp"
                )
            )
        ),

        //8
        Recipe(
            id = 8,
            description = "1. Сварить макароны, положить их на дно емкости для выпекания. " +
                    "Порезать помидоры тонкими ломтиками и положить их на макароны\n" +
                    "2. Сварите макароны, положите их на дно емкости для выпекания. Порежьте помидоры " +
                    "тонкими ломтиками и положите их на макароны\n" +
                    "3. Чеснок порезать и уложите на запеканку. Запекатье в духовке до " +
                    "готовности (примерно, 10–20 минут).",
            calories = 1183,
            title = "Макароны, запеченные с помидорами, под сыром",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120424123536/140707095137/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 26,
                    name = "Макароны",
                    amount_of_weeks_until_expired = 96,
                    image = "https://webpulse.imgsmail.ru/imgpreview?mb=webpulse&key=pulse_cabinet-image-cf554d59-a8b5-49b0-ba4e-60a81a261060"
                ),
                Ingridient(
                    id = 20,
                    name = "Чеснок",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083826/120327133119/p_O.jpg"
                ),
                Ingridient(
                    id = 21,
                    name = "Молотый черный перец",
                    amount_of_weeks_until_expired = 48,
                    image = "https://img.sunfruits.ru/images/products/1/7212/152927276/09e-640x640.jpg"
                ),
                Ingridient(
                    id = 18,
                    name = "Сыр",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/121220162751/121228225827/p_O.jpg"
                ),
                Ingridient(
                    id = 27,
                    name = "Помидоры",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175629/120327163412/p_O.jpg"
                )
            )
        ),

        //9
        Recipe(
            id = 9,
            description = "1. Разбейте яйца в миску и взболтайте их вилкой, добавьте помидор " +
                    "и тертый сыр\n" +
                    "2. На разогретую сковородку вылейте яично-помидорную смесь. Перемешивать смесь лопаткой.",
            calories = 464,
            title = "Омлет с помидорами",
            imageURL = "https://lobsterhouse.ru/wp-content/uploads/1/6/4/1647bb826d8dda15d01a79fc8e598be1.jpeg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 27,
                    name = "Помидоры",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175629/120327163412/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 28,
                    name = "Подсолнечное масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213182735/120912224631/p_O.jpg"
                )
            )
        ),

        //10
        Recipe(
            id = 10,
            description = "1. Взбить яйца с сахаром.\n" +
                    "2. Добавить остальные ингредиенты. Оставить на 20 минут.\n" +
                    "3. Жарить блины на сильно разогретой сковороде.",
            calories = 733,
            title = "Тонкие блины на молоке",
            imageURL = "https://www.povarenok.ru/data/cache/2019mar/10/57/2503065_42557-710x550x.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 11,
                    name = "Пшеничная мука",
                    amount_of_weeks_until_expired = 48,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131085333/120403130155/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Сахар",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328130714/p_O.jpg"
                ),
                Ingridient(
                    id = 10,
                    name = "Куриное яйцо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131034/p_O.jpg"
                ),
                Ingridient(
                    id = 28,
                    name = "Молоко",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131808/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 28,
                    name = "Подсолнечное масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213182735/120912224631/p_O.jpg"
                )

            )
        ),

        //11
        Recipe(
            id = 11,
            description = "1. Пожарить лук и морковь.\n" +
                    "2. Добавить в кастрюлю лук, морковь, кубики картошки и специи.\n" +
                    "3. Добавить сыр.\n" +
                    "4. Когда сыр растворится добавить зелень",
            calories = 357,
            title = "Сырный суп с зеленью",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/150730211652/150810161942/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 29,
                    name = "Плавленный сыр",
                    amount_of_weeks_until_expired = 1,
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgFBhGrsnufrizOX9IMIKdYSSCQTV2YBTwmQ&usqp=CAU"
                ),
                Ingridient(
                    id = 19,
                    name = "Лук репчатый",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083110/120911123915/p_O.jpg"
                ),
                Ingridient(
                    id = 24,
                    name = "Морковь",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173231/p_O.jpg"
                ),
                Ingridient(
                    id = 25,
                    name = "Укроп",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131220/p_O.jpg"
                ),
                Ingridient(
                    id = 30,
                    name = "Картофель",
                    amount_of_weeks_until_expired = 24,
                    image = "https://hzpc-sadokas.ru/tn_480x400_c_f_cc_ffffff_0/catalog/item/1000/7/Sylvana2013.jpg"
                ),
                Ingridient(
                    id = 31,
                    name = "Оливковое масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Oli_de_l%27Empord%C3%A0.jpg"
                )
            )
        ),

        //12
        Recipe(
            id = 12,
            description = "1. Поджарить хлеб.\n" +
                    "2. Разогреть сковороду, плеснуть в нее немного оливкового масла и " +
                    "высыпать в него помидоры и чеснок.\n" +
                    "3. Поджаренный хлеб пропитать оливковым маслом. Выложить теплые помидоры, " +
                    "посолить, посыпать свежемолотым черным перцем и мелко нарезанной зеленью",
            calories = 132,
            title = "Брускетта с помидорами",
            imageURL = "https://s1.eda.ru/StaticContent/Photos/120131085657/171214172307/p_O.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 32,
                    name = "Белый хлеб",
                    amount_of_weeks_until_expired = 1,
                    image = ""
                ),
                Ingridient(
                    id = 27,
                    name = "Помидоры",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175629/120327163412/p_O.jpg"
                ),
                Ingridient(
                    id = 31,
                    name = "Оливковое масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Oli_de_l%27Empord%C3%A0.jpg"
                ),
                Ingridient(
                    id = 20,
                    name = "Чеснок",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083826/120327133119/p_O.jpg"
                ),
                Ingridient(
                    id = 21,
                    name = "Молотый черный перец",
                    amount_of_weeks_until_expired = 48,
                    image = "https://img.sunfruits.ru/images/products/1/7212/152927276/09e-640x640.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 23,
                    name = "Петрушка",
                    amount_of_weeks_until_expired = 48,
                    image = "https://m.dom-eda.com/uploads/images/catalog/item/5ad9ef9fe7/2a55abbcb4_1000.jpg"
                ),
            )
        ),

        //13
        Recipe(
            id = 13,
            description = "1. Помидоры очистить, мелко нарезать. Чили избавить от семян и " +
                    "измельчить вместе с луком, чесноком и кинзой. Превратить чили, кинзу, помидоры " +
                    "и цедру лайма и лук в однородную пасту. Слегка посолить и снова перемешать.\n" +
                    "2. Добавить 1-2 столовые ложки воды и сок лайма.\n" +
                    "3. Очистить авокадо, удалить косточки, нарезать мякоть " +
                    "небольшими кубиками. Добавить к пасте из чили и помидоров и тщательно все размять.",
            calories = 342,
            title = "Гуакамоле",
            imageURL = "https://www.maggi.ru/data/images/recept/img640x500/recept_4580_gn48.jpg",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 33,
                    name = "Перец чили",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213185949/120327164841/p_O.jpg"
                ),
                Ingridient(
                    id = 34,
                    name = "Авокадо",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120327175138/p_O.jpg"
                ),
                Ingridient(
                    id = 27,
                    name = "Помидоры",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175629/120327163412/p_O.jpg"
                ),
                Ingridient(
                    id = 19,
                    name = "Лук репчатый",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083110/120911123915/p_O.jpg"
                ),
                Ingridient(
                    id = 35,
                    name = "Лайм",
                    amount_of_weeks_until_expired = 2,
                    image = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Limette.jpg/800px-Limette.jpg"
                ),
                Ingridient(
                    id = 36,
                    name = "Кинза",
                    amount_of_weeks_until_expired = 10,
                    image = "https://e1.edimdoma.ru/data/ingredients/0000/1230/1230-ed4_wide.jpg?1524474431"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 20,
                    name = "Чеснок",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083826/120327133119/p_O.jpg"
                )
            )
        ),

        //14
        Recipe(
            id = 14,
            description = "1. Каждый из цитрусовых залить кипятком на минуту. " +
                    "Срезать цедру, переложить её в большую огнеупорную чашу и залить 1,5 литрами " +
                    "кипящей воды, из фруктов выдавить сок и также отправить его в воду.\n" +
                    "2. Добавить цедру",
            calories = 114,
            title = "Домашний цитрусовый лимонад",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120214141717/120214142147/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 37,
                    name = "Лимон",
                    amount_of_weeks_until_expired = 4,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175233/120327153747/p_O.jpg"
                ),
                Ingridient(
                    id = 35,
                    name = "Лайм",
                    amount_of_weeks_until_expired = 2,
                    image = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Limette.jpg/800px-Limette.jpg"
                ),
                Ingridient(
                    id = 38,
                    name = "Апельсин",
                    amount_of_weeks_until_expired = 4,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214122930/120327165448/p_O.jpg"
                ),
                Ingridient(
                    id = 39,
                    name = "Мята",
                    amount_of_weeks_until_expired = 96,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120328191135/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Сахар",
                    amount_of_weeks_until_expired = 10000,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328130714/p_O.jpg"
                )
            )
        ),

        //15
        Recipe(
            id = 15,
            description = "Порезать ингредиенты и смешать.",
            calories = 150,
            title = "Салат из бананов, яблок и сельдерея",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120131111301/120214123726/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 40,
                    name = "Бананы",
                    amount_of_weeks_until_expired = 4,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214132605/120327171329/p_O.jpg"
                ),
                Ingridient(
                    id = 41,
                    name = "Яблоки",
                    amount_of_weeks_until_expired = 16,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328131655/p_O.jpg"
                ),
                Ingridient(
                    id = 42,
                    name = "Сельдерей",
                    amount_of_weeks_until_expired = 8,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120327190604/p_O.jpg"
                ),
                Ingridient(
                    id = 43,
                    name = "Сметана",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328132715/p_O.jpg"
                ),
                Ingridient(
                    id = 44,
                    name = "Йогурт",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214160714/120327173648/p_O.jpg"
                ),
                Ingridient(
                    id = 39,
                    name = "Мята",
                    amount_of_weeks_until_expired = 96,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120328191135/p_O.jpg"
                )
            )
        ),

        //16
        Recipe(
            id = 16,
            description = "1. Нарезать овощи.\n" +
                    "2. Смешать в маске оливковое масло, соль и перец, сухие травы. Положить овощи.\n" +
                    "3. Обжарить овощи на мангале.",
            calories = 132,
            title = "Овощи на мангале",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/d/a4/da41b77ab28a43b5b9a6b4148378a984.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 45,
                    name = "Баклажаны",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120304025019/120328132405/p_O.jpg"
                ),
                Ingridient(
                    id = 16,
                    name = "Кабачки",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120214130615/120327170200/p_O.jpg"
                ),
                Ingridient(
                    id = 19,
                    name = "Лук репчатый",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083110/120911123915/p_O.jpg"
                ),
                Ingridient(
                    id = 46,
                    name = "Сладкий перец",
                    amount_of_weeks_until_expired = 12,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173515/p_O.jpg"
                ),
                Ingridient(
                    id = 27,
                    name = "Помидоры",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213175629/120327163412/p_O.jpg"
                ),
                Ingridient(
                    id = 31,
                    name = "Оливковое масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Oli_de_l%27Empord%C3%A0.jpg"
                ),
                Ingridient(
                    id = 20,
                    name = "Чеснок",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083826/120327133119/p_O.jpg"
                ),
                Ingridient(
                    id = 25,
                    name = "Смесь пряных трав",
                    amount_of_weeks_until_expired = 48,
                    image = "https://zkrasa.ru/images/shop_items/352.jpg.webp"
                ),
                Ingridient(
                    id = 23,
                    name = "Петрушка",
                    amount_of_weeks_until_expired = 48,
                    image = "https://m.dom-eda.com/uploads/images/catalog/item/5ad9ef9fe7/2a55abbcb4_1000.jpg"
                ),
            )
        ),

        //17
        Recipe(
            id = 17,
            description = "1. Обжарить нарезанный болгарский перец.\n" +
                    "2. Добавить нарезанное кубиками куриное филе, слегка обжарить его, " +
                    "добавить нарезанный перец чили.\n" +
                    "3. Закрыть крышкой и тушить до готовности в течение 10 минут.",
            calories = 507,
            title = "Фахитас с курицей и фасолью",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120213175629/1202131757052/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 46,
                    name = "Сладкий перец",
                    amount_of_weeks_until_expired = 12,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173515/p_O.jpg"
                ),
                Ingridient(
                    id = 15,
                    name = "Филе куриной грудки",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c930x622/s1.eda.ru/StaticContent/Photos/140524182915/140530160514/p_O.jpg.webp"
                ),
                Ingridient(
                    id = 33,
                    name = "Перец чили",
                    amount_of_weeks_until_expired = 3,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213185949/120327164841/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 47,
                    name = "Консервированная фасоль",
                    amount_of_weeks_until_expired = 96,
                    image = "https://e1.edimdoma.ru/data/ingredients/0000/6226/6226-ed4_wide.jpg?1515753079"
                )
            )
        ),

        //18
        Recipe(
            id = 18,
            description = "1. Куриную грудку нарезать и обжарить.\n" +
                    "2. Овощи нарезать и положить к курице. Добавить фасоль.\n" +
                    "3. Кипящую воду посолить и положить курицу с овощами.",
            calories = 198,
            title = "Суп с фасолью и курицей",
            imageURL = "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/120214154125/120214154418/p_O.jpg.webp",
            ingridients = listOf<Ingridient>(
                Ingridient(
                    id = 15,
                    name = "Филе куриной грудки",
                    amount_of_weeks_until_expired = 1,
                    image = "https://eda.ru/img/eda/c930x622/s1.eda.ru/StaticContent/Photos/140524182915/140530160514/p_O.jpg.webp"
                ),
                Ingridient(
                    id = 47,
                    name = "Консервированная фасоль",
                    amount_of_weeks_until_expired = 96,
                    image = "https://e1.edimdoma.ru/data/ingredients/0000/6226/6226-ed4_wide.jpg?1515753079"
                ),
                Ingridient(
                    id = 46,
                    name = "Сладкий перец",
                    amount_of_weeks_until_expired = 12,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173515/p_O.jpg"
                ),
                Ingridient(
                    id = 24,
                    name = "Морковь",
                    amount_of_weeks_until_expired = 20,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120328144247/120329173231/p_O.jpg"
                ),
                Ingridient(
                    id = 12,
                    name = "Соль",
                    amount_of_weeks_until_expired = 120,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120131083019/120521142536/p_O.jpg"
                ),
                Ingridient(
                    id = 28,
                    name = "Подсолнечное масло",
                    amount_of_weeks_until_expired = 24,
                    image = "https://eda.ru/img/eda/c464x302/s1.eda.ru/StaticContent/Photos/120213182735/120912224631/p_O.jpg"
                )
            )
        ),
    )
}