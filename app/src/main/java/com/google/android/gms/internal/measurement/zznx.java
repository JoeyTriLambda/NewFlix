package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zznx implements zznu {
    private static final zzhg<Long> zza;
    private static final zzhg<String> zzaa;
    private static final zzhg<String> zzab;
    private static final zzhg<Long> zzac;
    private static final zzhg<String> zzad;
    private static final zzhg<String> zzae;
    private static final zzhg<String> zzaf;
    private static final zzhg<String> zzag;
    private static final zzhg<Long> zzah;
    private static final zzhg<Long> zzai;
    private static final zzhg<Long> zzaj;
    private static final zzhg<Long> zzak;
    private static final zzhg<Long> zzal;
    private static final zzhg<Long> zzam;
    private static final zzhg<Long> zzan;
    private static final zzhg<Long> zzao;
    private static final zzhg<Long> zzap;
    private static final zzhg<Long> zzaq;
    private static final zzhg<Long> zzar;
    private static final zzhg<Long> zzas;
    private static final zzhg<Long> zzat;
    private static final zzhg<Long> zzau;
    private static final zzhg<Long> zzav;
    private static final zzhg<Long> zzaw;
    private static final zzhg<Long> zzax;
    private static final zzhg<String> zzay;
    private static final zzhg<Long> zzaz;
    private static final zzhg<Long> zzb;
    private static final zzhg<String> zzba;
    private static final zzhg<Long> zzc;
    private static final zzhg<Long> zzd;
    private static final zzhg<String> zze;
    private static final zzhg<String> zzf;
    private static final zzhg<String> zzg;
    private static final zzhg<Long> zzh;
    private static final zzhg<String> zzi;
    private static final zzhg<Long> zzj;
    private static final zzhg<Long> zzk;
    private static final zzhg<Long> zzl;
    private static final zzhg<Long> zzm;
    private static final zzhg<Long> zzn;
    private static final zzhg<Long> zzo;
    private static final zzhg<Long> zzp;
    private static final zzhg<Long> zzq;
    private static final zzhg<Long> zzr;
    private static final zzhg<Long> zzs;
    private static final zzhg<Long> zzt;
    private static final zzhg<Long> zzu;
    private static final zzhg<String> zzv;
    private static final zzhg<Long> zzw;
    private static final zzhg<Long> zzx;
    private static final zzhg<Long> zzy;
    private static final zzhg<Long> zzz;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.ad_id_cache_time", 10000L);
        zzb = zzhoVarZza.zza("measurement.app_uninstalled_additional_ad_id_cache_time", DateUtils.MILLIS_PER_HOUR);
        zzc = zzhoVarZza.zza("measurement.max_bundles_per_iteration", 100L);
        zzd = zzhoVarZza.zza("measurement.config.cache_time", DateUtils.MILLIS_PER_DAY);
        zze = zzhoVarZza.zza("measurement.log_tag", "FA");
        zzf = zzhoVarZza.zza("measurement.config.url_authority", "app-measurement.com");
        zzg = zzhoVarZza.zza("measurement.config.url_scheme", "https");
        zzh = zzhoVarZza.zza("measurement.upload.debug_upload_interval", 1000L);
        zzi = zzhoVarZza.zza("measurement.rb.attribution.event_params", "value|currency");
        zzj = zzhoVarZza.zza("measurement.id.rb.attribution.app_allowlist", 0L);
        zzk = zzhoVarZza.zza("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzl = zzhoVarZza.zza("measurement.dma_consent.max_daily_dcu_realtime_events", 1L);
        zzm = zzhoVarZza.zza("measurement.upload.max_event_parameter_value_length", 100L);
        zzn = zzhoVarZza.zza("measurement.store.max_stored_events_per_app", 100000L);
        zzo = zzhoVarZza.zza("measurement.experiment.max_ids", 50L);
        zzp = zzhoVarZza.zza("measurement.audience.filter_result_max_count", 200L);
        zzq = zzhoVarZza.zza("measurement.upload.max_item_scoped_custom_parameters", 27L);
        zzr = zzhoVarZza.zza("measurement.rb.attribution.client.min_ad_services_version", 7L);
        zzs = zzhoVarZza.zza("measurement.alarm_manager.minimum_interval", DateUtils.MILLIS_PER_MINUTE);
        zzt = zzhoVarZza.zza("measurement.upload.minimum_delay", 500L);
        zzu = zzhoVarZza.zza("measurement.monitoring.sample_period_millis", DateUtils.MILLIS_PER_DAY);
        zzv = zzhoVarZza.zza("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,com.callapp.contacts,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid");
        zzw = zzhoVarZza.zza("measurement.upload.realtime_upload_interval", 10000L);
        zzx = zzhoVarZza.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zzy = zzhoVarZza.zza("measurement.config.cache_time.service", DateUtils.MILLIS_PER_HOUR);
        zzz = zzhoVarZza.zza("measurement.service_client.idle_disconnect_millis", 5000L);
        zzaa = zzhoVarZza.zza("measurement.log_tag.service", "FA-SVC");
        zzab = zzhoVarZza.zza("measurement.sgtm.app_allowlist", "");
        zzac = zzhoVarZza.zza("measurement.upload.stale_data_deletion_interval", DateUtils.MILLIS_PER_DAY);
        zzad = zzhoVarZza.zza("measurement.rb.attribution.uri_authority", "google-analytics.com");
        zzae = zzhoVarZza.zza("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        zzaf = zzhoVarZza.zza("measurement.rb.attribution.query_parameters_to_remove", "");
        zzag = zzhoVarZza.zza("measurement.rb.attribution.uri_scheme", "https");
        zzah = zzhoVarZza.zza("measurement.sdk.attribution.cache.ttl", 604800000L);
        zzai = zzhoVarZza.zza("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzaj = zzhoVarZza.zza("measurement.upload.backoff_period", 43200000L);
        zzak = zzhoVarZza.zza("measurement.upload.initial_upload_delay_time", 15000L);
        zzal = zzhoVarZza.zza("measurement.upload.interval", DateUtils.MILLIS_PER_HOUR);
        zzam = zzhoVarZza.zza("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzan = zzhoVarZza.zza("measurement.upload.max_bundles", 100L);
        zzao = zzhoVarZza.zza("measurement.upload.max_conversions_per_day", 500L);
        zzap = zzhoVarZza.zza("measurement.upload.max_error_events_per_day", 1000L);
        zzaq = zzhoVarZza.zza("measurement.upload.max_events_per_bundle", 1000L);
        zzar = zzhoVarZza.zza("measurement.upload.max_events_per_day", 100000L);
        zzas = zzhoVarZza.zza("measurement.upload.max_public_events_per_day", 50000L);
        zzat = zzhoVarZza.zza("measurement.upload.max_queue_time", 2419200000L);
        zzau = zzhoVarZza.zza("measurement.upload.max_realtime_events_per_day", 10L);
        zzav = zzhoVarZza.zza("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzaw = zzhoVarZza.zza("measurement.upload.retry_count", 6L);
        zzax = zzhoVarZza.zza("measurement.upload.retry_time", 1800000L);
        zzay = zzhoVarZza.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaz = zzhoVarZza.zza("measurement.upload.window_interval", DateUtils.MILLIS_PER_HOUR);
        zzba = zzhoVarZza.zza("measurement.rb.attribution.user_properties", "_npa,npa");
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zza() {
        return zza.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzaa() {
        return zzan.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzab() {
        return zzao.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzac() {
        return zzap.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzad() {
        return zzaq.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzae() {
        return zzar.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzaf() {
        return zzas.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzag() {
        return zzat.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzah() {
        return zzau.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzai() {
        return zzav.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzaj() {
        return zzaw.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzak() {
        return zzax.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzal() {
        return zzaz.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzam() {
        return zzf.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzan() {
        return zzg.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzao() {
        return zzi.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzap() {
        return zzv.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzaq() {
        return zzab.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzar() {
        return zzad.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzas() {
        return zzae.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzat() {
        return zzaf.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzau() {
        return zzag.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzav() {
        return zzay.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final String zzaw() {
        return zzba.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzb() {
        return zzb.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzc() {
        return zzc.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzd() {
        return zzd.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zze() {
        return zzh.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzf() {
        return zzk.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzg() {
        return zzl.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzh() {
        return zzm.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzi() {
        return zzn.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzj() {
        return zzo.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzk() {
        return zzp.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzl() {
        return zzq.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzm() {
        return zzr.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzn() {
        return zzs.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzo() {
        return zzt.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzp() {
        return zzu.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzq() {
        return zzw.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzr() {
        return zzx.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzs() {
        return zzz.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzt() {
        return zzac.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzu() {
        return zzah.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzv() {
        return zzai.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzw() {
        return zzaj.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzx() {
        return zzak.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzy() {
        return zzal.zza().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final long zzz() {
        return zzam.zza().longValue();
    }
}
