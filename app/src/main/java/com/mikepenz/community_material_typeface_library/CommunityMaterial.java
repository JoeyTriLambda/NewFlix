package com.mikepenz.community_material_typeface_library;

import android.content.Context;
import android.graphics.Typeface;
import da.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class CommunityMaterial {
    private static final String TTF_FILE = "communitymaterial-font-v1.8.36.1.ttf";
    private static HashMap<String, Character> mChars;
    private static Typeface typeface;

    public enum Icon implements a {
        /* JADX INFO: Fake field, exist only in values array */
        cmd_access_point(61442),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_access_point_network(61443),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account(61444),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_alert(61445),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_box(61446),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_box_outline(61447),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_card_details(62930),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_check(61448),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_circle(61449),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_convert(61450),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_edit(63163),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_key(61451),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_location(61452),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_minus(61453),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_multiple(61454),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_multiple_minus(62931),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_multiple_outline(61455),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_multiple_plus(61456),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_network(61457),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_off(61458),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_outline(61459),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_plus(61460),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_remove(61461),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_search(61462),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_settings(63024),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_settings_variant(63025),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_star(61463),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_star_variant(61464),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_account_switch(61465),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_adjust(61466),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_air_conditioner(61467),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airballoon(61468),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airplane(61469),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airplane_landing(62932),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airplane_off(61470),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airplane_takeoff(62933),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_airplay(61471),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm(61472),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm_check(61473),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm_multiple(61474),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm_off(61475),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm_plus(61476),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alarm_snooze(63117),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_album(61477),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert(61478),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_box(61479),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_circle(61480),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_circle_outline(62934),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_octagon(61481),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_octagram(63164),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alert_outline(61482),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_all_inclusive(63165),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alpha(61483),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_alphabetical(61484),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_altimeter(62935),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_amazon(61485),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_amazon_clouddrive(61486),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ambulance(61487),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_amplifier(61488),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_anchor(61489),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_android(61490),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_android_debug_bridge(61491),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_android_studio(61492),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_angular(63153),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_angularjs(63166),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_animation(62936),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple(61493),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_finder(61494),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_ios(61495),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_keyboard_caps(63026),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_keyboard_command(63027),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_keyboard_control(63028),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_keyboard_option(63029),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_keyboard_shift(63030),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_mobileme(61496),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apple_safari(61497),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_application(62996),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_apps(61499),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_archive(61500),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrange_bring_forward(61501),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrange_bring_to_front(61502),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrange_send_backward(61503),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrange_send_to_back(61504),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_all(61505),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_bottom_left(61506),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_bottom_right(61507),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_compress(62997),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_compress_all(61508),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down(61509),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_bold(61510),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_bold_circle(61511),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_bold_circle_outline(61512),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_bold_hexagon_outline(61513),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_box(63167),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_drop_circle(61514),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_down_drop_circle_outline(61515),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_expand(62998),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_expand_all(61516),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left(61517),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_bold(61518),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_bold_circle(61519),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_bold_circle_outline(61520),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_bold_hexagon_outline(61521),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_box(63168),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_drop_circle(61522),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_left_drop_circle_outline(61523),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right(61524),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_bold(61525),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_bold_circle(61526),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_bold_circle_outline(61527),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_bold_hexagon_outline(61528),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_box(63169),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_drop_circle(61529),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_right_drop_circle_outline(61530),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_top_left(61531),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_top_right(61532),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up(61533),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_bold(61534),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_bold_circle(61535),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_bold_circle_outline(61536),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_bold_hexagon_outline(61537),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_box(63170),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_drop_circle(61538),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_arrow_up_drop_circle_outline(61539),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_assistant(61540),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_asterisk(63171),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_at(61541),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_attachment(61542),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_audiobook(61543),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_auto_fix(61544),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_auto_upload(61545),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_autorenew(61546),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_av_timer(61547),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_baby(61548),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_baby_buggy(63118),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_backburger(61549),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_backspace(61550),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_backup_restore(61551),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bandcamp(63092),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bank(61552),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_barcode(61553),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_barcode_scan(61554),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_barley(61555),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_barrel(61556),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_basecamp(61557),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_basket(61558),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_basket_fill(61559),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_basket_unfill(61560),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery(61561),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_10(61562),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_20(61563),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_30(61564),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_40(61565),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_50(61566),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_60(61567),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_70(61568),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_80(61569),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_90(61570),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_alert(61571),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging(61572),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_100(61573),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_20(61574),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_30(61575),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_40(61576),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_60(61577),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_80(61578),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_charging_90(61579),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_minus(61580),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_negative(61581),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_outline(61582),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_plus(61583),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_positive(61584),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_battery_unknown(61585),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_beach(61586),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_beaker(63119),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_beats(61591),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_beer(61592),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_behance(61593),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell(61594),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_off(61595),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_outline(61596),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_plus(61597),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_ring(61598),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_ring_outline(61599),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bell_sleep(61600),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_beta(61601),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bible(61602),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bike(61603),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bing(61604),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_binoculars(61605),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bio(61606),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_biohazard(61607),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bitbucket(61608),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_black_mesa(61609),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blackberry(61610),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blender(61611),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blinds(61612),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_block_helper(61613),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blogger(61614),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth(61615),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth_audio(61616),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth_connect(61617),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth_off(61618),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth_settings(61619),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bluetooth_transfer(61620),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blur(61621),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blur_linear(61622),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blur_off(61623),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_blur_radial(61624),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bomb(63120),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bomb_off(63172),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bone(61625),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book(61626),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_minus(62937),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_multiple(61627),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_multiple_variant(61628),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_open(61629),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_open_page_variant(62938),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_open_variant(61630),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_plus(62939),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_book_variant(61631),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark(61632),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_check(61633),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_music(61634),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_outline(61635),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_plus(61637),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_plus_outline(61636),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bookmark_remove(61638),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_boombox(62940),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bootstrap(63173),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_all(61639),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_bottom(61640),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_color(61641),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_horizontal(61642),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_inside(61643),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_left(61644),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_none(61645),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_outside(61646),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_right(61647),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_style(61648),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_top(61649),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_border_vertical(61650),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bow_tie(63095),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bowl(62999),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bowling(61651),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_box(61652),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_box_cutter(61653),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_box_shadow(63031),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bridge(63000),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_briefcase(61654),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_briefcase_check(61655),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_briefcase_download(61656),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_briefcase_upload(61657),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_1(61658),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_2(61659),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_3(61660),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_4(61661),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_5(61662),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_6(61663),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_7(61664),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brightness_auto(61665),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_broom(61666),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_brush(61667),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_buffer(63001),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bug(61668),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bulletin_board(61669),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bullhorn(61670),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bullseye(62941),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_burst_mode(62942),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_bus(61671),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cached(61672),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cake(61673),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cake_layered(61674),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cake_variant(61675),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calculator(61676),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar(61677),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_blank(61678),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_check(61679),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_clock(61680),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_multiple(61681),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_multiple_check(61682),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_plus(61683),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_question(63121),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_range(63096),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_remove(61684),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_text(61685),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_calendar_today(61686),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_call_made(61687),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_call_merge(61688),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_call_missed(61689),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_call_received(61690),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_call_split(61691),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camcorder(61692),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camcorder_box(61693),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camcorder_box_off(61694),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camcorder_off(61695),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera(61696),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_burst(63122),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_enhance(61697),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_front(61698),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_front_variant(61699),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_iris(61700),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_off(62943),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_party_mode(61701),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_rear(61702),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_rear_variant(61703),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_switch(61704),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_camera_timer(61705),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_candle(62946),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_candycane(61706),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_car(61707),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_car_battery(61708),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_car_connected(61709),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_car_wash(61710),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cards(63032),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cards_outline(63033),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cards_playing_outline(63034),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cards_variant(63174),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_carrot(61711),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cart(61712),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cart_off(63083),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cart_outline(61713),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cart_plus(61714),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_case_sensitive_alt(61715),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cash(61716),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cash_100(61717),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cash_multiple(61718),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cash_usd(61719),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cast(61720),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cast_connected(61721),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_castle(61722),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cat(61723),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone(61724),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_android(61725),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_basic(61726),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_dock(61727),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_iphone(61728),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_link(61729),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_link_off(61730),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cellphone_settings(61731),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_certificate(61732),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chair_school(61733),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_arc(61734),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_areaspline(61735),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_bar(61736),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_bubble(62947),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_gantt(63084),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_histogram(61737),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_line(61738),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_pie(61739),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_scatterplot_hexbin(63085),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chart_timeline(63086),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_check(61740),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_check_all(61741),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_check_circle(62944),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_check_circle_outline(62945),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_blank(61742),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_blank_circle(61743),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_blank_circle_outline(61744),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_blank_outline(61745),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_marked(61746),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_marked_circle(61747),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_marked_circle_outline(61748),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_marked_outline(61749),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_blank(61750),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_blank_circle(63035),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_blank_circle_outline(63036),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_blank_outline(61751),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_marked(61752),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_marked_circle(63037),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_marked_circle_outline(63038),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkbox_multiple_marked_outline(61753),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_checkerboard(61754),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chemical_weapon(61755),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_double_down(61756),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_double_left(61757),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_double_right(61758),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_double_up(61759),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_down(61760),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_left(61761),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_right(61762),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chevron_up(61763),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_chip(63002),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_church(61764),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cisco_webex(61765),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_city(61766),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard(61767),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_account(61768),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_alert(61769),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_arrow_down(61770),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_arrow_left(61771),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_check(61772),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_flow(63175),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_outline(61773),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clipboard_text(61774),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clippy(61775),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock(61776),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_alert(62926),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_end(61777),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_fast(61778),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_in(61779),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_out(61780),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_clock_start(61781),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close(61782),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_box(61783),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_box_outline(61784),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_circle(61785),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_circle_outline(61786),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_network(61787),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_octagon(61788),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_octagon_outline(61789),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_close_outline(63176),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_closed_caption(61790),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud(61791),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_check(61792),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_circle(61793),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_download(61794),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_outline(61795),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_outline_off(61796),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_print(61797),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_print_outline(61798),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_sync(63039),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cloud_upload(61799),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_array(61800),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_braces(61801),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_brackets(61802),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_equal(61803),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_greater_than(61804),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_greater_than_or_equal(61805),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_less_than(61806),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_less_than_or_equal(61807),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_not_equal(61808),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_not_equal_variant(61809),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_parentheses(61810),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_string(61811),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_tags(61812),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_code_tags_check(63123),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_codepen(61813),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_coffee(61814),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_coffee_outline(63177),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_coffee_to_go(61815),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_coin(61816),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_coins(63124),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_collage(63040),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_color_helper(61817),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment(61818),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_account(61819),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_account_outline(61820),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_alert(61821),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_alert_outline(61822),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_check(61823),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_check_outline(61824),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_multiple_outline(61825),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_outline(61826),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_plus_outline(61827),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_processing(61828),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_processing_outline(61829),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_question_outline(61830),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_remove_outline(61831),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_text(61832),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_comment_text_outline(61833),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_compare(61834),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_compass(61835),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_compass_outline(61836),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_console(61837),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_contact_mail(61838),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_contacts(63178),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_copy(61839),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_cut(61840),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_duplicate(61841),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_paste(61842),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_save(61843),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_save_all(61844),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_content_save_settings(63003),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_contrast(61845),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_contrast_box(61846),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_contrast_circle(61847),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cookie(61848),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_copyright(62950),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_counter(61849),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cow(61850),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_creation(61897),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_credit_card(61851),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_credit_card_multiple(61852),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_credit_card_off(62948),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_credit_card_plus(63093),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_credit_card_scan(61853),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop(61854),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop_free(61855),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop_landscape(61856),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop_portrait(61857),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop_rotate(63125),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crop_square(61858),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crosshairs(61859),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crosshairs_gps(61860),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_crown(61861),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cube(61862),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cube_outline(61863),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cube_send(61864),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cube_unfolded(61865),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cup(61866),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cup_off(62949),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cup_water(61867),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_btc(61868),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_eur(61869),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_gbp(61870),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_inr(61871),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_ngn(61872),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_rub(61873),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_try(61874),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_usd(61875),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_currency_usd_off(63097),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cursor_default(61876),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cursor_default_outline(61877),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cursor_move(61878),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cursor_pointer(61879),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_cursor_text(62951),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_database(61880),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_database_minus(61881),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_database_plus(61882),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_debug_step_into(61883),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_debug_step_out(61884),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_debug_step_over(61885),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_decimal_decrease(61886),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_decimal_increase(61887),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete(61888),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete_circle(63106),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete_empty(63179),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete_forever(62952),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete_sweep(62953),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delete_variant(61889),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_delta(61890),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_deskphone(61891),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_desktop_mac(61892),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_desktop_tower(61893),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_details(61894),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_developer_board(63126),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_deviantart(61895),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dialpad(63004),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_diamond(61896),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_1(61898),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_2(61899),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_3(61900),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_4(61901),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_5(61902),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_6(61903),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_d20(62954),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_d4(62955),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_d6(62956),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dice_d8(62957),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dictionary(63005),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_directions(61904),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_directions_fork(63041),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_discord(63087),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_disk(62958),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_disk_alert(61905),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_disqus(61906),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_disqus_outline(61907),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_division(61908),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_division_box(61909),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dna(63107),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dns(61910),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_do_not_disturb(63127),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_do_not_disturb_off(63128),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dolby(63154),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_domain(61911),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dots_horizontal(61912),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dots_vertical(61913),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_douban(63129),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_download(61914),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drag(61915),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drag_horizontal(61916),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drag_vertical(61917),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drawing(61918),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drawing_box(61919),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dribbble(61920),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dribbble_box(61921),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drone(61922),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dropbox(61923),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_drupal(61924),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_duck(61925),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_dumbbell(61926),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_earth(61927),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_earth_box(63180),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_earth_box_off(63181),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_earth_off(61928),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_edge(61929),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eject(61930),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_elevation_decline(61931),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_elevation_rise(61932),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_elevator(61933),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email(61934),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_alert(63182),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_open(61935),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_open_outline(62959),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_outline(61936),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_secure(61937),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_email_variant(62960),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emby(63155),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon(61938),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_cool(61939),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_dead(63130),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_devil(61940),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_excited(63131),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_happy(61941),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_neutral(61942),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_poop(61943),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_sad(61944),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_emoticon_tongue(61945),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_engine(61946),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_engine_outline(61947),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_equal(61948),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_equal_box(61949),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eraser(61950),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eraser_variant(63042),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_escalator(61951),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ethernet(61952),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ethernet_cable(61953),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ethernet_cable_off(61954),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_etsy(61955),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ev_station(62961),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_evernote(61956),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_exclamation(61957),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_exit_to_app(61958),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_export(61959),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eye(61960),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eye_off(61961),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eye_outline(63183),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eye_outline_off(63184),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eyedropper(61962),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_eyedropper_variant(61963),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_face(63043),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_face_profile(63044),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_facebook(61964),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_facebook_box(61965),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_facebook_messenger(61966),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_factory(61967),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fan(61968),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fast_forward(61969),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fast_forward_outline(63185),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fax(61970),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_feather(63186),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ferry(61971),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file(61972),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_chart(61973),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_check(61974),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_cloud(61975),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_delimited(61976),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_document(61977),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_document_box(61978),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_excel(61979),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_excel_box(61980),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_export(61981),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_find(61982),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_hidden(62995),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_image(61983),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_import(61984),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_lock(61985),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_multiple(61986),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_music(61987),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_outline(61988),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_pdf(61989),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_pdf_box(61990),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_powerpoint(61991),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_powerpoint_box(61992),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_presentation_box(61993),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_restore(63088),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_send(61994),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_tree(63045),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_video(61995),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_word(61996),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_word_box(61997),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_file_xml(61998),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_film(61999),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filmstrip(62000),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filmstrip_off(62001),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filter(62002),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filter_outline(62003),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filter_remove(62004),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filter_remove_outline(62005),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_filter_variant(62006),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_find_replace(63187),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fingerprint(62007),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fire(62008),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_firefox(62009),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fish(62010),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag(62011),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag_checkered(62012),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag_outline(62013),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag_outline_variant(62014),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag_triangle(62015),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flag_variant(62016),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flash(62017),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flash_auto(62018),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flash_off(62019),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flash_outline(63188),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flash_red_eye(63098),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flashlight(62020),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flashlight_off(62021),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flask(61587),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flask_empty(61588),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flask_empty_outline(61589),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flask_outline(61590),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flattr(62022),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flip_to_back(62023),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flip_to_front(62024),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_floppy(62025),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_flower(62026),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder(62027),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_account(62028),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_download(62029),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_google_drive(62030),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_image(62031),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_lock(62032),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_lock_open(62033),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_move(62034),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_multiple(62035),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_multiple_image(62036),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_multiple_outline(62037),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_outline(62038),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_plus(62039),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_remove(62040),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_star(63132),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_folder_upload(62041),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_font_awesome(61498),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_food(62042),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_food_apple(62043),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_food_fork_drink(62962),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_food_off(62963),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_food_variant(62044),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_football(62045),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_football_australian(62046),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_football_helmet(62047),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_align_center(62048),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_align_justify(62049),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_align_left(62050),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_align_right(62051),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_annotation_plus(63046),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_bold(62052),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_clear(62053),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_color_fill(62054),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_color_text(63133),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_float_center(62055),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_float_left(62056),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_float_none(62057),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_float_right(62058),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_font(63189),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_1(62059),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_2(62060),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_3(62061),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_4(62062),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_5(62063),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_6(62064),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_decrease(62065),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_equal(62066),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_increase(62067),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_header_pound(62068),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_horizontal_align_center(63006),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_horizontal_align_left(63007),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_horizontal_align_right(63008),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_indent_decrease(62069),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_indent_increase(62070),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_italic(62071),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_line_spacing(62072),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_line_style(62920),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_line_weight(62921),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_list_bulleted(62073),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_list_bulleted_type(62074),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_list_numbers(62075),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_page_break(63190),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_paint(62076),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_paragraph(62077),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_pilcrow(63191),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_quote(62078),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_rotate_90(63145),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_section(63134),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_size(62079),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_strikethrough(62080),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_strikethrough_variant(62081),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_subscript(62082),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_superscript(62083),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_text(62084),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_textdirection_l_to_r(62085),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_textdirection_r_to_l(62086),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_title(62964),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_underline(62087),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_vertical_align_bottom(63009),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_vertical_align_center(63010),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_vertical_align_top(63011),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_wrap_inline(62088),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_wrap_square(62089),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_wrap_tight(62090),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_format_wrap_top_bottom(62091),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_forum(62092),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_forward(62093),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_foursquare(62094),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fridge(62095),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fridge_filled(62096),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fridge_filled_bottom(62097),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fridge_filled_top(62098),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fullscreen(62099),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_fullscreen_exit(62100),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_function(62101),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gamepad(62102),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gamepad_variant(62103),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_garage(63192),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_garage_open(63193),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gas_cylinder(63047),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gas_station(62104),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gate(62105),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gauge(62106),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gavel(62107),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gender_female(62108),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gender_male(62109),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gender_male_female(62110),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gender_transgender(62111),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ghost(62112),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gift(62113),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_git(62114),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_github_box(62115),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_github_circle(62116),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_github_face(63194),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glass_flute(62117),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glass_mug(62118),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glass_stange(62119),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glass_tulip(62120),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glassdoor(62121),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_glasses(62122),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gmail(62123),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gnome(62124),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gondola(63109),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google(62125),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_cardboard(62126),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_chrome(62127),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_circles(62128),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_circles_communities(62129),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_circles_extended(62130),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_circles_group(62131),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_controller(62132),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_controller_off(62133),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_drive(62134),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_earth(62135),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_glass(62136),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_keep(63195),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_maps(62965),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_nearby(62137),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_pages(62138),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_photos(63196),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_physical_web(62139),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_play(62140),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_plus(62141),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_plus_box(62142),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_translate(62143),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_google_wallet(62144),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_gradient(63135),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_grease_pencil(63048),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_grid(62145),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_grid_off(62146),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_group(62147),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_guitar_electric(62148),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_guitar_pick(62149),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_guitar_pick_outline(62150),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hackernews(63012),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hamburger(63108),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hand_pointing_right(62151),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hanger(62152),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hangouts(62153),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_harddisk(62154),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headphones(62155),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headphones_box(62156),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headphones_settings(62157),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headset(62158),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headset_dock(62159),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_headset_off(62160),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart(62161),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_box(62162),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_box_outline(62163),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_broken(62164),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_half_outline(63197),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_half_part(63198),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_half_part_outline(63199),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_outline(62165),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_heart_pulse(62966),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_help(62166),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_help_circle(62167),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_help_circle_outline(63013),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hexagon(62168),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hexagon_multiple(63200),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hexagon_outline(62169),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_highway(62967),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_history(62170),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hololens(62171),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_home(62172),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_home_map_marker(62968),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_home_modern(62173),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_home_outline(63136),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_home_variant(62174),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hook(63201),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hook_off(63202),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hops(62175),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hospital(62176),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hospital_building(62177),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hospital_marker(62178),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_hotel(62179),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_houzz(62180),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_houzz_box(62181),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human(62182),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_child(62183),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_female(63049),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_greeting(63050),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_handsdown(63051),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_handsup(63052),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_male(63053),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_male_female(62184),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_human_pregnant(62927),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image(62185),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_album(62186),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_area(62187),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_area_close(62188),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_broken(62189),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_broken_variant(62190),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter(62191),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_black_white(62192),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_center_focus(62193),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_center_focus_weak(62194),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_drama(62195),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_frames(62196),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_hdr(62197),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_none(62198),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_tilt_shift(62199),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_filter_vintage(62200),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_image_multiple(62201),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_import(62202),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_inbox(63110),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_inbox_arrow_down(62203),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_inbox_arrow_up(62417),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_incognito(62969),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_infinity(63203),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_information(62204),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_information_outline(62205),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_information_variant(63054),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_instagram(62206),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_instapaper(62207),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_internet_explorer(62208),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_invert_colors(62209),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_itunes(63094),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_jeepney(62210),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_jira(62211),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_jsfiddle(62212),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_json(63014),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keg(62213),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_kettle(62970),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key(62214),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key_change(62215),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key_minus(62216),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key_plus(62217),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key_remove(62218),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_key_variant(62219),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard(62220),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_backspace(62221),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_caps(62222),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_close(62223),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_off(62224),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_return(62225),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_tab(62226),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_keyboard_variant(62227),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_kodi(62228),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_label(62229),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_label_outline(62230),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lambda(63015),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lamp(63156),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lan(62231),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lan_connect(62232),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lan_disconnect(62233),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lan_pending(62234),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_c(63089),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_cpp(63090),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_csharp(62235),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_css3(62236),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_html5(62237),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_javascript(62238),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_php(62239),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_python(62240),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_python_text(62241),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_swift(63204),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_language_typescript(63205),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_laptop(62242),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_laptop_chromebook(62243),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_laptop_mac(62244),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_laptop_off(63206),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_laptop_windows(62245),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lastfm(62246),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_launch(62247),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_layers(62248),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_layers_off(62249),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lead_pencil(63055),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_leaf(62250),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_off(62251),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_on(62252),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_outline(62253),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_variant_off(62254),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_variant_on(62255),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_led_variant_outline(62256),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_library(62257),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_library_books(62258),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_library_music(62259),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_library_plus(62260),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lightbulb(62261),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lightbulb_on(63207),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lightbulb_on_outline(63208),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lightbulb_outline(62262),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_link(62263),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_link_off(62264),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_link_variant(62265),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_link_variant_off(62266),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_linkedin(62267),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_linkedin_box(62268),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_linux(62269),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock(62270),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock_open(62271),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock_open_outline(62272),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock_outline(62273),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock_pattern(63209),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lock_plus(62971),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_login(62274),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_login_variant(62972),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_logout(62275),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_logout_variant(62973),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_looks(62276),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_loop(63210),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_loupe(62277),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_lumx(62278),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnet(62279),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnet_on(62280),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnify(62281),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnify_minus(62282),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnify_minus_outline(63211),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnify_plus(62283),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_magnify_plus_outline(63212),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mail_ru(62284),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mailbox(63213),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map(62285),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker(62286),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_circle(62287),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_minus(63056),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_multiple(62288),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_off(62289),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_plus(63057),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_map_marker_radius(62290),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_margin(62291),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_markdown(62292),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_marker(63058),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_marker_check(62293),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_martini(62294),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_material_ui(62295),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_math_compass(62296),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_matrix(63016),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_maxcdn(62297),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_medical_bag(63214),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_medium(62298),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_memory(62299),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu(62300),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_down(62301),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_down_outline(63157),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_left(62302),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_right(62303),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_up(62304),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_menu_up_outline(63158),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message(62305),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_alert(62306),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_bulleted(63137),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_bulleted_off(63138),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_draw(62307),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_image(62308),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_outline(62309),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_plus(63059),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_processing(62310),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_reply(62311),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_reply_text(62312),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_settings(63215),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_settings_variant(63216),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_text(62313),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_text_outline(62314),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_message_video(62315),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_meteor(63017),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone(62316),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone_off(62317),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone_outline(62318),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone_settings(62319),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone_variant(62320),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microphone_variant_off(62321),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microscope(63060),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_microsoft(62322),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minecraft(62323),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus(62324),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus_box(62325),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus_box_outline(63217),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus_circle(62326),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus_circle_outline(62327),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_minus_network(62328),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mixcloud(63018),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_monitor(62329),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_monitor_multiple(62330),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_more(62331),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_motorbike(62332),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mouse(62333),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mouse_off(62334),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mouse_variant(62335),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_mouse_variant_off(62336),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_move_resize(63061),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_move_resize_variant(63062),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_movie(62337),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_multiplication(62338),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_multiplication_box(62339),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_box(62340),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_box_outline(62341),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_circle(62342),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note(62343),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_bluetooth(62974),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_bluetooth_off(62975),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_eighth(62344),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_half(62345),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_off(62346),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_quarter(62347),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_sixteenth(62348),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_music_note_whole(62349),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nature(62350),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nature_people(62351),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_navigation(62352),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_near_me(62925),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_needle(62353),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nest_protect(62354),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nest_thermostat(62355),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_network(63218),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_network_download(63219),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_network_question(63220),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_network_upload(63221),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_new_box(62356),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_newspaper(62357),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nfc(62358),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nfc_tap(62359),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nfc_variant(62360),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nodejs(62361),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note(62362),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_multiple(63159),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_multiple_outline(63160),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_outline(62363),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_plus(62364),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_plus_outline(62365),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_note_text(62366),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_notification_clear_all(62367),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_npm(63222),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nuke(63139),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric(62368),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_0_box(62369),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_0_box_multiple_outline(62370),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_0_box_outline(62371),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_1_box(62372),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_1_box_multiple_outline(62373),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_1_box_outline(62374),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_2_box(62375),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_2_box_multiple_outline(62376),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_2_box_outline(62377),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_3_box(62378),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_3_box_multiple_outline(62379),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_3_box_outline(62380),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_4_box(62381),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_4_box_multiple_outline(62382),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_4_box_outline(62383),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_5_box(62384),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_5_box_multiple_outline(62385),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_5_box_outline(62386),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_6_box(62387),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_6_box_multiple_outline(62388),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_6_box_outline(62389),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_7_box(62390),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_7_box_multiple_outline(62391),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_7_box_outline(62392),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_8_box(62393),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_8_box_multiple_outline(62394),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_8_box_outline(62395),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_box(62396),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_box_multiple_outline(62397),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_box_outline(62398),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_plus_box(62399),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_plus_box_multiple_outline(62400),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_numeric_9_plus_box_outline(62401),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nut(63223),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_nutrition(62402),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_oar(63099),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_octagon(62403),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_octagon_outline(62404),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_octagram(63224),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_odnoklassniki(62405),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_office(62406),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_oil(62407),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_oil_temperature(62408),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_omega(62409),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_onedrive(62410),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_opacity(62924),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_open_in_app(62411),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_open_in_new(62412),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_openid(62413),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_opera(62414),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ornament(62415),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ornament_variant(62416),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_owl(62418),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_package(62419),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_package_down(62420),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_package_up(62421),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_package_variant(62422),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_package_variant_closed(62423),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_first(62976),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_last(62977),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_layout_body(63225),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_layout_footer(63226),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_layout_header(63227),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_layout_sidebar_left(63228),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_page_layout_sidebar_right(63229),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_palette(62424),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_palette_advanced(62425),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panda(62426),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pandora(62427),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panorama(62428),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panorama_fisheye(62429),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panorama_horizontal(62430),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panorama_vertical(62431),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_panorama_wide_angle(62432),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_paper_cut_vertical(62433),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_paperclip(62434),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_parking(62435),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pause(62436),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pause_circle(62437),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pause_circle_outline(62438),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pause_octagon(62439),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pause_octagon_outline(62440),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_paw(62441),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_paw_off(63063),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pen(62442),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil(62443),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil_box(62444),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil_box_outline(62445),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil_circle(63230),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil_lock(62446),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pencil_off(62447),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pentagon(63231),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pentagon_outline(63232),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_percent(62448),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pharmacy(62449),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone(62450),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_bluetooth(62451),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_classic(62978),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_forward(62452),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_hangup(62453),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_in_talk(62454),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_incoming(62455),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_locked(62456),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_log(62457),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_minus(63064),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_missed(62458),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_outgoing(62459),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_paused(62460),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_plus(63065),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_settings(62461),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_phone_voip(62462),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pi(62463),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pi_box(62464),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_piano(63100),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pig(62465),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pill(62466),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pillar(63233),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pin(62467),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pin_off(62468),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pine_tree(62469),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pine_tree_box(62470),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pinterest(62471),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pinterest_box(62472),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pistol(63234),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pizza(62473),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plane_shield(63162),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play(62474),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play_box_outline(62475),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play_circle(62476),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play_circle_outline(62477),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play_pause(62478),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_play_protected_content(62479),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playlist_check(62919),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playlist_minus(62480),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playlist_play(62481),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playlist_plus(62482),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playlist_remove(62483),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_playstation(62484),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plex(63161),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus(62485),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_box(62486),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_box_outline(63235),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_circle(62487),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_circle_multiple_outline(62488),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_circle_outline(62489),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_network(62490),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_one(62491),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_plus_outline(63236),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pocket(62492),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pokeball(62493),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_polaroid(62494),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_poll(62495),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_poll_box(62496),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_polymer(62497),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pool(62982),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_popcorn(62498),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pot(63066),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pot_mix(63067),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pound(62499),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pound_box(62500),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_power(62501),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_power_plug(63140),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_power_plug_off(63141),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_power_settings(62502),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_power_socket(62503),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_prescription(63237),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_presentation(62504),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_presentation_play(62505),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_printer(62506),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_printer_3d(62507),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_printer_alert(62508),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_printer_settings(63238),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_priority_high(62979),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_priority_low(62980),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_professional_hexagon(62509),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_projector(62510),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_projector_screen(62511),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_publish(63142),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_pulse(62512),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_puzzle(62513),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_qqchat(62981),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_qrcode(62514),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_qrcode_scan(62515),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_quadcopter(62516),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_quality_high(62517),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_quicktime(62518),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radar(62519),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radiator(62520),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radio(62521),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radio_handheld(62522),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radio_tower(62523),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radioactive(62524),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radiobox_blank(62525),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_radiobox_marked(62526),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_raspberrypi(62527),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_end(62528),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_end_arrow(62529),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_start(62530),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_start_arrow(62531),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_start_end(62532),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ray_vertex(62533),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rdio(62534),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_react(63239),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_read(62535),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_readability(62536),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_receipt(62537),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_record(62538),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_record_rec(62539),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_recycle(62540),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reddit(62541),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_redo(62542),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_redo_variant(62543),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_refresh(62544),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_regex(62545),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_relative_scale(62546),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reload(62547),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_remote(62548),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rename_box(62549),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reorder_horizontal(63111),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reorder_vertical(63112),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_repeat(62550),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_repeat_off(62551),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_repeat_once(62552),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_replay(62553),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reply(62554),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reply_all(62555),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_reproduction(62556),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_resize_bottom_right(62557),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_responsive(62558),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_restart(63240),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_restore(63143),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rewind(62559),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rewind_outline(63241),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rhombus(63242),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rhombus_outline(63243),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ribbon(62560),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_road(62561),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_road_variant(62562),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_robot(63144),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rocket(62563),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_roomba(63244),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rotate_3d(62564),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rotate_left(62565),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rotate_left_variant(62566),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rotate_right(62567),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rotate_right_variant(62568),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rounded_corner(62983),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_router_wireless(62569),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_routes(62570),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rowing(62984),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rss(62571),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_rss_box(62572),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ruler(62573),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_run(63245),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_run_fast(62574),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sale(62575),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_satellite(62576),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_satellite_variant(62577),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_saxophone(62985),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_scale(62578),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_scale_balance(62929),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_scale_bathroom(62579),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_scanner(63146),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_school(62580),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_screen_rotation(62581),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_screen_rotation_lock(62582),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_screwdriver(62583),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_script(62584),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sd(62585),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seal(62586),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_search_web(63246),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_flat(62587),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_flat_angled(62588),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_individual_suite(62589),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_legroom_extra(62590),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_legroom_normal(62591),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_legroom_reduced(62592),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_recline_extra(62593),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_seat_recline_normal(62594),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_security(62595),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_security_home(63113),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_security_network(62596),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_select(62597),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_select_all(62598),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_select_inverse(62599),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_select_off(62600),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_selection(62601),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_send(62602),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_serial_port(63068),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server(62603),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_minus(62604),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_network(62605),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_network_off(62606),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_off(62607),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_plus(62608),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_remove(62609),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_server_security(62610),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_settings(62611),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_settings_box(62612),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shape_circle_plus(63069),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shape_plus(62613),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shape_polygon_plus(63070),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shape_rectangle_plus(63071),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shape_square_plus(63072),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_share(62614),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_share_variant(62615),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shield(62616),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shield_outline(62617),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shopping(62618),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shopping_music(62619),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shovel(63247),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shovel_off(63248),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shredder(62620),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shuffle(62621),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shuffle_disabled(62622),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_shuffle_variant(62623),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sigma(62624),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sigma_lower(63019),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sign_caution(62625),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal(62626),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_2g(63249),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_3g(63250),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_4g(63251),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_hspa(63252),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_hspa_plus(63253),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_signal_variant(62986),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_silverware(62627),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_silverware_fork(62628),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_silverware_spoon(62629),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_silverware_variant(62630),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sim(62631),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sim_alert(62632),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sim_off(62633),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sitemap(62634),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_backward(62635),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_forward(62636),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_next(62637),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_next_circle(63073),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_next_circle_outline(63074),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_previous(62638),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_previous_circle(63075),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skip_previous_circle_outline(63076),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skull(63115),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skype(62639),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_skype_business(62640),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_slack(62641),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sleep(62642),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sleep_off(62643),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_smoking(62644),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_smoking_off(62645),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_snapchat(62646),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_snowflake(63254),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_snowman(62647),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_soccer(62648),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sofa(62649),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_solid(63116),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort(62650),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort_alphabetical(62651),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort_ascending(62652),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort_descending(62653),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort_numeric(62654),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sort_variant(62655),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_soundcloud(62656),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_branch(63020),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit(63255),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_end(63256),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_end_local(63257),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_local(63258),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_next_local(63259),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_start(63260),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_commit_start_next_local(63261),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_fork(62657),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_merge(63021),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_source_pull(62658),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_speaker(62659),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_speaker_off(62660),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_speaker_wireless(63262),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_speedometer(62661),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_spellcheck(62662),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_spotify(62663),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_spotlight(62664),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_spotlight_beam(62665),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_spray(63077),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_square_inc(62666),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_square_inc_cash(62667),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stackexchange(62987),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stackoverflow(62668),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stadium(63263),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stairs(62669),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_star(62670),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_star_circle(62671),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_star_half(62672),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_star_off(62673),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_star_outline(62674),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_steam(62675),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_steering(62676),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_step_backward(62677),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_step_backward_2(62678),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_step_forward(62679),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_step_forward_2(62680),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stethoscope(62681),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sticker(62928),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stocking(62682),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stop(62683),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stop_circle(63078),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stop_circle_outline(63079),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_store(62684),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_store_24_hour(62685),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_stove(62686),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_subdirectory_arrow_left(62988),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_subdirectory_arrow_right(62989),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_subway(63147),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_subway_variant(62687),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sunglasses(62688),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_surround_sound(62917),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_svg(63264),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_swap_horizontal(62689),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_swap_vertical(62690),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_swim(62691),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_switch(62692),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sword(62693),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sync(62694),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sync_alert(62695),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_sync_off(62696),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tab(62697),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tab_unselected(62698),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table(62699),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_column_plus_after(62700),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_column_plus_before(62701),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_column_remove(62702),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_column_width(62703),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_edit(62704),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_large(62705),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_row_height(62706),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_row_plus_after(62707),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_row_plus_before(62708),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_table_row_remove(62709),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tablet(62710),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tablet_android(62711),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tablet_ipad(62712),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag(62713),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_faces(62714),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_heart(63114),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_multiple(62715),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_outline(62716),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_plus(63265),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_remove(63266),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tag_text_outline(62717),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_target(62718),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_taxi(62719),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_teamviewer(62720),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_telegram(62721),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_television(62722),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_television_guide(62723),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_temperature_celsius(62724),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_temperature_fahrenheit(62725),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_temperature_kelvin(62726),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tennis(62727),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tent(62728),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_terrain(62729),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_test_tube(63080),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_text_shadow(63081),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_text_to_speech(62730),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_text_to_speech_off(62731),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_textbox(62990),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_texture(62732),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_theater(62733),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_theme_light_dark(62734),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thermometer(62735),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thermometer_lines(62736),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thumb_down(62737),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thumb_down_outline(62738),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thumb_up(62739),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thumb_up_outline(62740),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_thumbs_up_down(62741),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ticket(62742),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ticket_account(62743),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ticket_confirmation(62744),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ticket_percent(63267),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tie(62745),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tilde(63268),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timelapse(62746),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer(62747),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer_10(62748),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer_3(62749),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer_off(62750),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer_sand(62751),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timer_sand_empty(63148),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_timetable(62752),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_toggle_switch(62753),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_toggle_switch_off(62754),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip(62755),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip_edit(62756),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip_image(62757),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip_outline(62758),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip_outline_plus(62759),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooltip_text(62760),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tooth(62761),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tor(62762),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tower_beach(63104),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tower_fire(63105),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_traffic_light(62763),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_train(62764),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tram(62765),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_transcribe(62766),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_transcribe_close(62767),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_transfer(62768),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_transit_transfer(63149),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_translate(62922),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_treasure_chest(63269),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tree(62769),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trello(62770),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trending_down(62771),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trending_neutral(62772),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trending_up(62773),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_triangle(62774),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_triangle_outline(62775),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trophy(62776),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trophy_award(62777),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trophy_outline(62778),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trophy_variant(62779),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_trophy_variant_outline(62780),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_truck(62781),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_truck_delivery(62782),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_truck_trailer(63270),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tshirt_crew(62783),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tshirt_v(62784),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tumblr(62785),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tumblr_reblog(62786),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tune(63022),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_tune_vertical(63082),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_twitch(62787),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_twitter(62788),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_twitter_box(62789),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_twitter_circle(62790),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_twitter_retweet(62791),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ubuntu(62792),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_umbraco(62793),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_umbrella(62794),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_umbrella_outline(62795),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_undo(62796),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_undo_variant(62797),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_unfold_less(62798),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_unfold_more(62799),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_ungroup(62800),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_unity(63150),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_untappd(62801),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_update(63151),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_upload(62802),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_usb(62803),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_arrange_above(62804),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_arrange_below(62805),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_circle(62806),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_circle_variant(62807),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_combine(62808),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_curve(62809),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_difference(62810),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_difference_ab(62811),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_difference_ba(62812),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_intersection(62813),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_line(62814),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_point(62815),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_polygon(62816),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_polyline(62817),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_rectangle(62918),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_selection(62818),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_square(61441),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_triangle(62819),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vector_union(62820),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_verified(62821),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vibrate(62822),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_video(62823),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_video_off(62824),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_video_switch(62825),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_agenda(62826),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_array(62827),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_carousel(62828),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_column(62829),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_dashboard(62830),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_day(62831),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_grid(62832),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_headline(62833),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_list(62834),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_module(62835),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_parallel(63271),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_quilt(62836),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_sequential(63272),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_stream(62837),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_view_week(62838),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vimeo(62839),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vine(62840),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_violin(62991),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_visualstudio(62992),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vk(62841),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vk_box(62842),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vk_circle(62843),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vlc(62844),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_voice(62923),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_voicemail(62845),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_volume_high(62846),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_volume_low(62847),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_volume_medium(62848),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_volume_off(62849),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_vpn(62850),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_walk(62851),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wallet(62852),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wallet_giftcard(62853),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wallet_membership(62854),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wallet_travel(62855),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wan(62856),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_washing_machine(63273),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_watch(62857),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_watch_export(62858),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_watch_import(62859),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_watch_vibrate(63152),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_water(62860),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_water_off(62861),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_water_percent(62862),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_water_pump(62863),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_watermark(62994),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_cloudy(62864),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_fog(62865),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_hail(62866),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_lightning(62867),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_lightning_rainy(63101),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_night(62868),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_partlycloudy(62869),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_pouring(62870),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_rainy(62871),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_snowy(62872),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_snowy_rainy(63102),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_sunny(62873),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_sunset(62874),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_sunset_down(62875),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_sunset_up(62876),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_windy(62877),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weather_windy_variant(62878),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_web(62879),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_webcam(62880),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_webhook(63023),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_webpack(63274),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wechat(62993),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weight(62881),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_weight_kilogram(62882),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_whatsapp(62883),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wheelchair_accessibility(62884),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_white_balance_auto(62885),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_white_balance_incandescent(62886),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_white_balance_iridescent(62887),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_white_balance_sunny(62888),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_widgets(63275),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wifi(62889),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wifi_off(62890),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wii(62891),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wiiu(63276),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wikipedia(62892),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_close(62893),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_closed(62894),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_maximize(62895),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_minimize(62896),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_open(62897),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_window_restore(62898),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_windows(62899),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wordpress(62900),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_worker(62901),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wrap(62902),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wrench(62903),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_wunderlist(62904),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xaml(63091),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xbox(62905),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xbox_controller(62906),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xbox_controller_off(62907),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xda(62908),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xing(62909),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xing_box(62910),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xing_circle(62911),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_xml(62912),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_yeast(62913),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_yelp(62914),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_yin_yang(63103),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_youtube_play(62915),
        /* JADX INFO: Fake field, exist only in values array */
        cmd_zip_box(62916);


        /* renamed from: b, reason: collision with root package name */
        public final char f10279b;

        Icon(char c10) {
            this.f10279b = c10;
        }
    }

    public String getAuthor() {
        return "Templarian / Community / Google";
    }

    public HashMap<String, Character> getCharacters() {
        if (mChars == null) {
            HashMap<String, Character> map = new HashMap<>();
            for (Icon icon : Icon.values()) {
                map.put(icon.name(), Character.valueOf(icon.f10279b));
            }
            mChars = map;
        }
        return mChars;
    }

    public String getDescription() {
        return "Material Design Icons are the official open-source icons featured in the Google Material Design specification.";
    }

    public String getFontName() {
        return "Community Material Design";
    }

    public a getIcon(String str) {
        return Icon.valueOf(str);
    }

    public int getIconCount() {
        return mChars.size();
    }

    public Collection<String> getIcons() {
        LinkedList linkedList = new LinkedList();
        for (Icon icon : Icon.values()) {
            linkedList.add(icon.name());
        }
        return linkedList;
    }

    public String getLicense() {
        return "Templates - Free, Community Icons - SIL Open Font License 1.1, Google Material Design Icons: Attribution 4.0 International";
    }

    public String getLicenseUrl() {
        return "https://raw.githubusercontent.com/Templarian/MaterialDesign/master/license.txt";
    }

    public String getMappingPrefix() {
        return "cmd";
    }

    public Typeface getTypeface(Context context) {
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/communitymaterial-font-v1.8.36.1.ttf");
            } catch (Exception unused) {
                return null;
            }
        }
        return typeface;
    }

    public String getUrl() {
        return "http://materialdesignicons.com/";
    }

    public String getVersion() {
        return "1.8.36.1";
    }
}
